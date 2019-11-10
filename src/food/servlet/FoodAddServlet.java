package food.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.dao.FoodDao;
import food.table.Food;

/**
 * Servlet implementation class FoodAddServlet
 */
@WebServlet("/FoodAdd")
public class FoodAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(
		        "/FoodAdd.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		      ServletContext sc = this.getServletContext();
		      FoodDao foodDao = (FoodDao)sc.getAttribute("foodDao");

		      request.setCharacterEncoding("UTF-8");
		      response.setContentType("text/html;charset=UTF-8");

		      
		      String[] atrbt = request.getParameterValues("ATRBT[]");  
		      String tmp = "";
		      for(String val:atrbt)
		      {
		    	  tmp += val;
		      }
		      
		      
		      foodDao.insert(new Food()
		        .setFname(request.getParameter("fname"))
		        .setKind(request.getParameter("kind"))
		        .setMaterial(tmp+request.getParameter("material")));
		      
		      sc.setAttribute("foods", foodDao.selectList());

		      response.sendRedirect("FoodAddSuccess.jsp");

		    } catch (Exception e) {
		      e.printStackTrace();
		      request.setAttribute("error", e);
		      RequestDispatcher rd = request.getRequestDispatcher("/FoodAddError.jsp");
		      rd.forward(request, response);
		    }
		  
	}

}
