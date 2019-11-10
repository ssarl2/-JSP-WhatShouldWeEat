package board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.dao.BoardDao;
import food.table.Board;
import food.table.Member;

@WebServlet("/BoardAdd")
public class BoardAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/board/BoardAdd.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			//현재 접속회원 아이디 호출
			HttpSession session = request.getSession();
			Member user = (Member)session.getAttribute("member");
			
			//디버깅의 편리성을 위해 변수 따로 선언
			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			boardDao.insert(new Board()
					.setTitle(title)
					.setContents(contents)
					.setId(user.getId())
					);

			response.sendRedirect("Board");
			
	    } catch (Exception e) {
	      e.printStackTrace();
	      request.setAttribute("error", e);
	      RequestDispatcher rd = request.getRequestDispatcher("/BoardAddError.jsp");
	      rd.forward(request, response);
	    }
	  }
}
