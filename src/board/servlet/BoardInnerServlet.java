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

@WebServlet("/BoardInner")
public class BoardInnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");

			//해당 게시글 번호 받아서 조회수 증가
			//디버깅의 편리성을 위해 변수 따로 선언
			int views = Integer.parseInt(request.getParameter("views"));
			int bno = Integer.parseInt(request.getParameter("bno"));
			boardDao.updateViews(new Board()
					.setViews(views)
					.setBno(bno));
			
			//해당 게시글 번호 받아서 값 받아옴
			Board board = boardDao.selectBoard(Integer.parseInt(request.getParameter("bno")));
			
			//현재 접속회원 아이디 호출
			HttpSession session = request.getSession();
			Member user = (Member)session.getAttribute("member");
			
			//해당 게시글 작성자 아이디랑 현재 유저 아이디 비교 후 오브젝트 불린객체에 저장
			Boolean check = user.getId().equals(board.getId());
			
			//값 JSP내장객체에 저장
			request.setAttribute("board", board);
			request.setAttribute("check", check);
			
			//값 Inner.jsp에 전송
			RequestDispatcher rd = request.getRequestDispatcher("/board/BoardInner.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/BoardInnerError.jsp");
			rd.forward(request, response);
		}
	}
}
