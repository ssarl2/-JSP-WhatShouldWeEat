package food.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food.dao.FoodDao;
import food.dao.MemberDao;
import food.table.Food;
import food.table.Member;
import food.util.MaterialSelecter;

/**
 * Servlet implementation class FoodSelectServlet
 */
@WebServlet("/FoodSelect")
public class FoodSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			HttpSession session = request.getSession();
			MaterialSelecter ms = new MaterialSelecter();
			
			FoodDao foodDao = (FoodDao)sc.getAttribute("foodDao");
			int count = (int)session.getAttribute("count");
			
			if(count<1) //ó�� �����̶��
			{
				session.setAttribute("selects", foodDao.selectList()); //������ ���� ��� �ʱ�ȭ
				session.setAttribute("pastAnswer", new ArrayList<String>());
			}
			
			ArrayList<Food> selects = (ArrayList<Food>)session.getAttribute("selects"); //������ ����� ���ĸ��
			ArrayList<String> pastAnswer = (ArrayList<String>)session.getAttribute("pastAnswer");
			String question = ms.question(selects,pastAnswer); // ���� ������
			
			session.setAttribute("question", question); //����
			
			RequestDispatcher rd = request.getRequestDispatcher("/FoodSelect.jsp");
			rd.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		    request.setAttribute("error", e);
		    RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
		    rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			  HttpSession session = request.getSession();
		      boolean answer = Boolean.parseBoolean(request.getParameter("answer")); //���
		      String question = (String)session.getAttribute("question"); //����
		      ArrayList<String> pastAnswer = (ArrayList<String>)session.getAttribute("pastAnswer");
		      int count = (int)session.getAttribute("count");
		      
		      ArrayList<Food> selects = (ArrayList<Food>)session.getAttribute("selects"); //������ ����� ���ĸ��
		      //�������δ� requset�� ���󰡴µ� �����Ͱ� �������� �غ���
		      
		      
		      
		      MaterialSelecter ms = new MaterialSelecter();
		      
		      if(answer) pastAnswer.add(question); //�����̾����� ����
		      
		      selects = ms.select(selects,question,answer);
		      count = count+1;
		      
		      if(selects.size()==1)
		      {
		    	  String result = selects.get(0).getFname();
		    	  
		    	  ServletContext sc = this.getServletContext();
		    	  MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
			      
		    	  Member member = (Member)session.getAttribute("member");
		    	  
		    	  member.setSelects(member.getSelects()+result+","); //����� �ֱ�
		    	  session.setAttribute("member", member);
					
		    	  memberDao.update(new Member()
		    			  .setId(member.getId())
		    			  .setPw(member.getPw())
		    			  .setAge(member.getAge())
		    			  .setSex(member.getSex())
		    			  .setSelects(member.getSelects())); // ������Ʈ
		    	  
		    	  request.setAttribute("result", result); //��� �ѱ��
		    	  
		    	  
		    	  RequestDispatcher rd = request.getRequestDispatcher("FoodResult.jsp");
			      rd.forward(request, response);
		      }
		      else if(selects.size() == 0)
		      {
		    	  String result = "��";
		    	  request.setAttribute("result", result); //��� �ѱ��
		    	  
		    	  RequestDispatcher rd = request.getRequestDispatcher("FoodResult.jsp");
			      rd.forward(request, response);
		      }
		      else 
		      {
		    	  question = ms.question(selects,pastAnswer); // ���� ������
		    	  
		    	  
		    	  
			      session.setAttribute("selects", selects); //������ ���� ���
			      session.setAttribute("question", question); //����
			      session.setAttribute("count", count);
			      session.setAttribute("pastAnswer", pastAnswer);
			      
			      response.sendRedirect("FoodSelect"); // �ݺ�  
		      }
		      

		    } catch (Exception e) {
		      e.printStackTrace();
		      request.setAttribute("error", e);
		      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
		      rd.forward(request, response);
		    }
	}

}
