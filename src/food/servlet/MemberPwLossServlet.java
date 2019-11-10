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
import food.util.MailSender;

/**
 * Servlet implementation class MemberPwLossServlet
 */
@WebServlet("/PasswordLoss")
public class MemberPwLossServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPwLossServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/MemberPwLoss.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			  ServletContext sc = this.getServletContext();
		      MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
		      MailSender ms = new MailSender();
		      String lossId = request.getParameter("lossId");
		      
		      if(memberDao.exist(lossId))
		      {
		    	  String tmpw = ms.getRandomString(8); //임시 비밀번호 생성
			      
			      request.setCharacterEncoding("UTF-8");
			      response.setContentType("text/html;charset=UTF-8");
			      
			      String pwTmp = memberDao.pwEncryption(tmpw); // 암호화
			      
			      memberDao.pwChange(pwTmp, lossId); // 적용
			      
			      
			      

			      ms.send(request.getParameter("lossId"), tmpw);
			      
			      response.sendRedirect("PwChangeSuccess.jsp");
		      }
		      else
		      {
		    	  response.sendRedirect("PwChangeError.jsp");
		      }
		      
		}catch(Exception e){
		      e.printStackTrace();
		      request.setAttribute("error", e);
		      RequestDispatcher rd = request.getRequestDispatcher("/PwChangeError.jsp");
		      rd.forward(request, response);
		}
	}

}
