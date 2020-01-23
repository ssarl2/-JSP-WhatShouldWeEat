package food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import food.table.Food;

public class FoodDao {
	DataSource ds;
	
	private FoodDao()
	{
		super();
	}
	public static FoodDao getInstance() {
		return new FoodDao();
	}
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	
	public ArrayList<Food>selectList() throws Exception//throws SQLException
	{
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select fname,kind,material from foods");
			ArrayList<Food> foods = new ArrayList<Food>();
			while(rs.next())
			{
				foods.add(new Food()
						.setFname(rs.getString("fname"))
						.setKind(rs.getString("kind"))
						.setMaterial(rs.getString("material"))
				);
			}
			return foods;
		}
		catch (Exception e)
		{
			throw e;
		}
		finally 
		{
			try {if (rs != null) rs.close();} catch(Exception e) {}
		    try {if (stmt != null) stmt.close();} catch(Exception e) {}
		    try {if (connection != null) connection.close();} catch(Exception e) {}
		}
		
		
	}
	
	public int insert(Food food) throws Exception  {  // 음식 생성 
	    Connection connection = null;
	    PreparedStatement stmt = null;

	    try {
	      connection = ds.getConnection();
	      stmt = connection.prepareStatement(
	          "insert into foods(fname,kind,material)"
	              + " values (?,?,?)");
	      stmt.setString(1, food.getFname());
	      stmt.setString(2, food.getKind()); 
	      stmt.setString(3, food.getMaterial());
	      return stmt.executeUpdate();

	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	  }

	  public int delete(String fname) throws Exception {  
	    Connection connection = null;
	    Statement stmt = null;

	    try {
	      connection = ds.getConnection();
	      stmt = connection.createStatement();
	      return stmt.executeUpdate(
	          "delete from foods where fname = '"+ fname +"'" );  //혹시나 ' 필요없으면 빼기

	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	  }

	  public boolean selectOne(String fname) throws Exception { 
		    Connection connection = null;
		    Statement stmt = null;
		    ResultSet rs = null;
		    try {
		      connection = ds.getConnection();
		      stmt = connection.createStatement();
		      rs = stmt.executeQuery(
		          "select fname,kind,material from foods" + 
		              " where fname='" + fname+"'");    
		      if (rs.next()) return true;
		      else return false;

		    } catch (Exception e) {
		      throw e;
		    } finally {
		      try {if (rs != null) rs.close();} catch(Exception e) {}
		      try {if (stmt != null) stmt.close();} catch(Exception e) {}
		      try {if (connection != null) connection.close();} catch(Exception e) {}
		    }
		  }
	  
	  public int update(Food food) throws Exception { 
	    Connection connection = null;
	    PreparedStatement stmt = null;
	    try {
	      connection = ds.getConnection();
	      stmt = connection.prepareStatement(
	          "update foods set material=?"
	              + " where fname=?");
	      stmt.setString(1, food.getMaterial()); // 넣을때 기존에 있는거 + 추가한걸로 해야함
	      stmt.setString(2, food.getFname());
	      return stmt.executeUpdate();

	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	  }
	  
	  
}
