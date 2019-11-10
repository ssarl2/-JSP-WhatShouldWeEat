package board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.dao.BoardDao;
import food.table.Board;

@WebServlet("/BoardEdit")
public class BoardEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			//디버깅의 편리성을 위해 변수 따로 선언
			int bno = Integer.parseInt(request.getParameter("bno"));
			Board board = boardDao.selectBoard(bno);
			
			request.setAttribute("board", board);
			
			RequestDispatcher rd = request.getRequestDispatcher("/board/BoardEdit.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/BoardEditGetError.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			//디버깅의 편리성을 위해 변수 따로 선언
			int bno = Integer.parseInt(request.getParameter("bno"));
			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			
			boardDao.update(new Board()
					.setBno(bno)
					.setTitle(title)
					.setContents(contents)
					);
			
			response.sendRedirect("Board");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/BoardEditPostError.jsp");
			rd.forward(request, response);
		}
	}
}
