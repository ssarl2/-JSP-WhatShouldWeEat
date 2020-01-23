package food.listener;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import food.dao.BoardDao;
import food.dao.FoodDao;
import food.dao.MemberDao;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
      ServletContext sc = event.getServletContext();
      
      InitialContext initialContext = new InitialContext();
      DataSource ds = (DataSource)initialContext.lookup(
          "java:comp/env/jdbc/fooddb");

      FoodDao foodDao = FoodDao.getInstance();
      foodDao.setDataSource(ds);
      
      MemberDao memberDao = MemberDao.getInstance();
      memberDao.setDataSource(ds); 
      
      BoardDao boardDao = BoardDao.getInstance();
      boardDao.setDataSource(ds); 
      
      sc.setAttribute("foodDao", foodDao);
      sc.setAttribute("memberDao", memberDao);
      sc.setAttribute("boardDao", boardDao);

      sc.setAttribute("members", memberDao.selectList());
      
    } catch(Throwable e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {}
}