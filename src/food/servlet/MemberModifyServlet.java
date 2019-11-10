package food.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.dao.MemberDao;
import food.table.Member;

/**
 * Servlet implementation class MemberModifyServlet
 */
@WebServlet("/MemberModify")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/MemberModify.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		try {
			ServletContext sc = this.getServletContext();
			MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");

			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
	      
			HttpSession session = request.getSession();
			Member member = (Member)session.getAttribute("member");
			
			String pwTmp = memberDao.pwEncryption(request.getParameter("pw"));
			
			if(!member.getPw().equals(pwTmp))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/MemberModifyError.jsp");
				rd.forward(request, response);
			}
			
			String newPwTmp = memberDao.pwEncryption(request.getParameter("newPw"));
			
			member.setPw(newPwTmp); //세션에 있는 값도 수정
			session.setAttribute("member", member);
			
			memberDao.update(new Member()
						.setId(member.getId())
						.setPw(newPwTmp)
						.setAge(Integer.parseInt(request.getParameter("age")))
						.setSex(request.getParameter("sex"))
						.setSelects(member.getSelects()));
			
			response.sendRedirect("MemberModifySuccess.jsp");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/MemberModifyError.jsp");
			rd.forward(request, response);
	}
	}

}
