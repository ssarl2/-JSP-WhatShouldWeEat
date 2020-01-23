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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(
		        "/Login.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		      ServletContext sc = this.getServletContext();
		      MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao"); 
		      Member member = memberDao.exist(
		          request.getParameter("id"), 
		          request.getParameter("pw"));
		      if (member != null) {
		        HttpSession session = request.getSession();
		        session.setAttribute("member", member);
		        session.setAttribute("count", 0);
		        RequestDispatcher rd = request.getRequestDispatcher(
			            "FoodMain.jsp");
			    rd.forward(request, response);

		      } else {
		    	  /*response.sendRedirect("test.jsp?test=Å×½ºÆ®")*/
		        RequestDispatcher rd = request.getRequestDispatcher(
		            "LoginFail.jsp");
		        rd.forward(request, response);
		      }
		    } catch (Exception e) {
		    	e.printStackTrace();
				request.setAttribute("error", e);
				RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
				rd.forward(request, response);

		    }

	
	}

}
