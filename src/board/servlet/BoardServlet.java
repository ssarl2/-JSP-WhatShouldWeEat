package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.dao.BoardDao;
import food.table.Board;

@WebServlet("/Board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html;charset=UTF-8");
			
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			request.setAttribute("board", boardDao.selectListBoard());
			
			RequestDispatcher rd = request.getRequestDispatcher("/board/Board.jsp");
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/BoardError.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//요청정보 몸체에 있는 문자열들을 인자값으로 지정한 문자코드로 인코딩한다.
	        request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
	        
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			String title = request.getParameter("title");
			List<Board> boardList = boardDao.searchBoard(title);
			
			request.setAttribute("board", boardList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/board/Board.jsp");
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/BoardError.jsp");
			rd.forward(request, response);
		}
	}

}