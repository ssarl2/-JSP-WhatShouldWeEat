package food.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.dao.MemberDao;
import food.table.Member;

/**
 * Servlet implementation class MemberAddServlet
 */
@WebServlet("/MemberAdd")
public class MemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/MemberAdd.jsp");
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
		      
		      String pwTmp = memberDao.pwEncryption(request.getParameter("pw"));
		      
		      memberDao.insert(new Member()
				        .setId(request.getParameter("id"))
				        .setPw(pwTmp)
				        .setAge(Integer.parseInt(request.getParameter("age")))
				        .setSex(request.getParameter("sex")));
		      
		      sc.setAttribute("members", memberDao.selectList());

		      response.sendRedirect("MemberAddSuccess.jsp");
		}catch(Exception e){
		      e.printStackTrace();
		      request.setAttribute("error", e);
		      RequestDispatcher rd = request.getRequestDispatcher("/MemberAddError.jsp");
		      rd.forward(request, response);
		}
		
	}

}
