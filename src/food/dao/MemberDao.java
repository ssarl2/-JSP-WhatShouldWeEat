package food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import food.table.Member;

public class MemberDao {
	DataSource ds;
	
	private MemberDao()
	{
		super();
	}
	public static MemberDao getInstance() {
		return new MemberDao();
	}
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public ArrayList<Member>selectList() throws Exception//throws SQLException
	{
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select id,pw,age,sex,selects from members");
			ArrayList<Member> members = new ArrayList<Member>();
			while(rs.next())
			{
				members.add(new Member()
						.setId(rs.getString("id"))
						.setPw(rs.getString("pw"))
						.setAge(rs.getInt("age"))
						.setSex(rs.getString("sex"))
						.setSelects(rs.getString("selects"))
				);
			}
			return members;
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
	
	public int insert(Member member) throws Exception  {  // 회원 생성 
	    Connection connection = null;
	    PreparedStatement stmt = null;

	    try {
	      connection = ds.getConnection();
	      stmt = connection.prepareStatement(
	          "insert into members(id,pw,age,sex)"
	              + " values (?,?,?,?)");
	      stmt.setString(1, member.getId());
	      stmt.setString(2, member.getPw()); //암호화 해야햄 ------------------------------------------------------------<
	      stmt.setInt(3, member.getAge());
	      stmt.setString(4, member.getSex());
	      return stmt.executeUpdate();

	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	  }

	  public int delete(String id) throws Exception {  
	    Connection connection = null;
	    Statement stmt = null;

	    try {
	      connection = ds.getConnection();
	      stmt = connection.createStatement();
	      return stmt.executeUpdate(
	          "delete from members where id = '"+ id +"'" );

	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	  }

	  
	  
	  public int update(Member member) throws Exception { 
	    Connection connection = null;
	    PreparedStatement stmt = null;
	    try {
	      connection = ds.getConnection();
	      stmt = connection.prepareStatement(
	          "update members set pw=?,age=?,sex=?,selects=?"
	              + " where id=?");
	      stmt.setString(1, member.getPw()); // 비밀번호 넣을 때 이미 암ㅇ호화 해야하는구나
	      stmt.setInt(2, member.getAge());
	      stmt.setString(3, member.getSex());
	      stmt.setString(4, member.getSelects());
	      stmt.setString(5, member.getId());
	      return stmt.executeUpdate();

	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	  }
	  
	  public int pwChange(String pw, String id) throws Exception { 
		    Connection connection = null;
		    PreparedStatement stmt = null;
		    try {
		      connection = ds.getConnection();
		      stmt = connection.prepareStatement(
		          "update members set pw=?"
		              + " where id=?");
		      stmt.setString(1, pw);
		      stmt.setString(2, id);
		      return stmt.executeUpdate();

		    } catch (Exception e) {
		      throw e;

		    } finally {
		      try {if (stmt != null) stmt.close();} catch(Exception e) {}
		      try {if (connection != null) connection.close();} catch(Exception e) {}
		    }
		  }
	  
	  public Member exist(String id, String pw) throws Exception {
	    Connection connection = null;
	    PreparedStatement stmt = null, pwSt = null;
	    ResultSet rs = null, pwTmp = null;
	    

	    try {
	      connection = ds.getConnection();
	      
	      pwSt = connection.prepareStatement("select concat('*', convert(sha1(unhex(sha1(?))) USING utf8mb4))");//여기서 입력한 password 복호화
	      pwSt.setString(1, pw);
	      pwTmp = pwSt.executeQuery();
	      while(pwTmp.next()){pw = pwTmp.getString(1);}
	      
	      stmt = connection.prepareStatement(
	          "select id,pw,age,sex,selects from members"
	              + " where id=? and pw=?");
	      stmt.setString(1, id);
	      stmt.setString(2, pw);
	      rs = stmt.executeQuery();
	      if (rs.next()) {
	        return new Member()
	          .setId(rs.getString("id"))
	          .setPw(rs.getString("pw"))
	          .setAge(rs.getInt("age"))
	          .setSex(rs.getString("sex"))
	          .setSelects(rs.getString("selects"));
	      } else {
	        return null;
	      }
	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (pwTmp != null) pwTmp.close();} catch (Exception e) {}
		  try {if (pwSt != null) pwSt.close();} catch (Exception e) {}
	      try {if (rs != null) rs.close();} catch (Exception e) {}
	      try {if (stmt != null) stmt.close();} catch (Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	  }
	  
	  public boolean exist(String id) throws Exception {
		    Connection connection = null;
		    PreparedStatement stmt = null, pwSt = null;
		    ResultSet rs = null, pwTmp = null;
		    

		    try {
		      connection = ds.getConnection();
		      
		      stmt = connection.prepareStatement(
		          "select id,pw,age,sex,selects from members"
		              + " where id=?");
		      stmt.setString(1, id);
		      rs = stmt.executeQuery();
		      if (rs.next()) {
		        return true;
		      } else {
		        return false;
		      }
		    } catch (Exception e) {
		      throw e;

		    } finally {
		      try {if (pwTmp != null) pwTmp.close();} catch (Exception e) {}
			  try {if (pwSt != null) pwSt.close();} catch (Exception e) {}
		      try {if (rs != null) rs.close();} catch (Exception e) {}
		      try {if (stmt != null) stmt.close();} catch (Exception e) {}
		      try {if (connection != null) connection.close();} catch(Exception e) {}
		    }
		  }
	  
	  public String pwEncryption(String pw) throws Exception{
		  Connection connection = null;
		    PreparedStatement pwSt = null;
		    ResultSet pwTmp = null;
		    

		    try {
		      connection = ds.getConnection();
		      
		      pwSt = connection.prepareStatement("select concat('*', convert(sha1(unhex(sha1(?))) USING utf8mb4))");//여기서 입력한 password 복호화
		      pwSt.setString(1, pw);
		      pwTmp = pwSt.executeQuery();
		      while(pwTmp.next()){pw = pwTmp.getString(1);}
		      	
		      return pw;
		    } catch (Exception e) {
		      throw e;

		    } finally {
		      try {if (pwTmp != null) pwTmp.close();} catch (Exception e) {}
			  try {if (pwSt != null) pwSt.close();} catch (Exception e) {}
		      try {if (connection != null) connection.close();} catch(Exception e) {}
		    }
	  }
}
