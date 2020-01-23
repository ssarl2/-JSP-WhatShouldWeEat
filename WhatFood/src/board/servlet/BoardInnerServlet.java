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

			//�ش� �Խñ� ��ȣ �޾Ƽ� ��ȸ�� ����
			//������� ������ ���� ���� ���� ����
			int views = Integer.parseInt(request.getParameter("views"));
			int bno = Integer.parseInt(request.getParameter("bno"));
			boardDao.updateViews(new Board()
					.setViews(views)
					.setBno(bno));
			
			//�ش� �Խñ� ��ȣ �޾Ƽ� �� �޾ƿ�
			Board board = boardDao.selectBoard(Integer.parseInt(request.getParameter("bno")));
			
			//���� ����ȸ�� ���̵� ȣ��
			HttpSession session = request.getSession();
			Member user = (Member)session.getAttribute("member");
			
			//�ش� �Խñ� �ۼ��� ���̵�� ���� ���� ���̵� �� �� ������Ʈ �Ҹ���ü�� ����
			Boolean check = user.getId().equals(board.getId());
			
			//�� JSP���尴ü�� ����
			request.setAttribute("board", board);
			request.setAttribute("check", check);
			
			//�� Inner.jsp�� ����
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
