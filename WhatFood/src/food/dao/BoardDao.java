package food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import food.table.Board;

public class BoardDao {
	DataSource ds;

	public BoardDao() {
		super();
	}

	public static BoardDao getInstance() {
		return new BoardDao();
	}

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	/**
	 * ��ü ����Ʈ
	 * @return
	 * @throws Exception
	 */
	public List<Board> selectListBoard() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			String sql = "select * from board";
			rs = stmt.executeQuery(sql);

			ArrayList<Board> board = new ArrayList<Board>();

			while (rs.next()) {
				board.add(new Board()
						.setBno(rs.getInt("bno"))
						.setTitle(rs.getString("title"))
						.setContents(rs.getString("contents"))
						.setId(rs.getString("id"))
						.setViews(rs.getInt("views"))
						.setCreated(rs.getString("created")));
			}
			return board;
		} catch (Exception e) {
			throw e;
		} finally {
			try {if (rs != null)rs.close();} catch (Exception e) {}
			try {if (stmt != null)stmt.close();} catch (Exception e) {}
			try {if (connection != null)connection.close();} catch (Exception e) {}
		}
	}

	/**
	 * �Խ��� �˻� ���
	 * @return
	 * @throws Exception
	 */
	public List<Board> searchBoard(String title) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			String sql = "select * from board where title like '%" + title + "%\'";
			rs = stmt.executeQuery(sql);
			
			ArrayList<Board> searchList = new ArrayList<Board>();
			
			while (rs.next()) {
				searchList.add(new Board()
						.setBno(rs.getInt("bno"))
						.setTitle(rs.getString("title"))
						.setContents(rs.getString("contents"))
						.setId(rs.getString("id"))
						.setViews(rs.getInt("views"))
						.setCreated(rs.getString("created")));
			}
			return searchList;
		} catch (Exception e) {
			throw e;
		} finally {
			try {if (rs != null)rs.close();} catch (Exception e) {}
			try {if (stmt != null)stmt.close();} catch (Exception e) {}
			try {if (connection != null)connection.close();} catch (Exception e) {}
		}
	}
	
	/**
	 * �ش� ��ȣ ��ü ��ȯ
	 * @param bno
	 * @return
	 * @throws Exception
	 */
	public Board selectBoard(int bno) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			String sql = "select * from board where bno=" + bno;
			rs = stmt.executeQuery(sql);
			if (rs.next()) {return new Board()
					.setBno(rs.getInt("bno"))
					.setTitle(rs.getString("title"))
					.setContents(rs.getString("contents"))
					.setId(rs.getString("id"))
					.setViews(rs.getInt("views"))
					.setCreated(rs.getString("created"));
			} else {
				throw new Exception("�ش� ��ȣ�� ȸ���� ã�� �� �����ϴ�.");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {if (rs != null)rs.close();} catch (Exception e) {}
			try {if (stmt != null)stmt.close();} catch (Exception e) {}
			try {if (connection != null)connection.close();} catch (Exception e) {}
		}
	}

	/**
	 * �Խñ� �ۼ�
	 * @param board
	 * @return
	 * @throws Exception
	 */
	public int insert(Board board) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = ds.getConnection();
			String sql = "insert into board(title,contents,id,created) values(?,?,?,now())";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getContents());
			stmt.setString(3, board.getId());
			return stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			try {if (stmt != null)stmt.close();} catch (Exception e) {}
			try {if (connection != null)connection.close();} catch (Exception e) {}
		}
	}
	
	/**
	 * �Խñ� ����
	 * @param board
	 * @return
	 * @throws Exception
	 */
	public int update(Board board) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = ds.getConnection();
			String sql = "update board set title=?,contents=? where bno=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getContents());
			stmt.setInt(3, board.getBno());
			return stmt.executeUpdate();
		} catch (Exception e) {
			throw e;

		} finally {
			try {if (stmt != null)stmt.close();} catch (Exception e) {}
			try {if (connection != null)connection.close();	} catch (Exception e) {}
		}
	}
	
	/**
	 * ��ȸ�� ����
	 * @param board
	 * @return
	 * @throws Exception
	 */
	public int updateViews(Board board) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = ds.getConnection();
			String sql = "update board set views=? where bno=?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, board.getViews());
			stmt.setInt(2, board.getBno());
			return stmt.executeUpdate();
		} catch (Exception e) {
			throw e;

		} finally {
			try {if (stmt != null)stmt.close();} catch (Exception e) {}
			try {if (connection != null)connection.close();	} catch (Exception e) {}
		}
	}
	
	/**
	 * �Խñ� ����
	 * @param bno
	 * @return
	 * @throws Exception
	 */
	public int deleteBoard(int bno) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			String sql = "delete from board where bno="+bno;
			return stmt.executeUpdate(sql);
		} catch (Exception e) {
			throw e;
		} finally {
			try {if (stmt != null) stmt.close();} catch (Exception e) {}
			try {if (connection != null) connection.close();} catch (Exception e) {}
		}
	}

}
