package food.util;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class MailSender {
 
    public void send(String id, String tmpw) {
        //��ó : http://fruitdev.tistory.com/15
        Properties p = System.getProperties();
        p.put("mail.smtp.starttls.enable", "true");     // gmail�� ������ true ����
        p.put("mail.smtp.host", "smtp.gmail.com");      // smtp ���� �ּ�
        p.put("mail.smtp.auth","true");                 // gmail�� ������ true ����
        p.put("mail.smtp.port", "587");                 // gmail ��Ʈ
           
        Authenticator auth = new MyAuthentication();
         
        //session ���� ��  MimeMessage����
        Session session = Session.getDefaultInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);
        String MainText = 
        			"�ȳ��ϼ���. "+ id +" ��, " +
        			"���� �� ������ �������Դϴ�.<br>" +
        			"�ӽ� ��й�ȣ�� " + tmpw + " �Դϴ�.<br>" +
        			"�Է� �� ȸ������ �������� ��й�ȣ �缳�� �Ͻñ� �ٶ��ϴ�.";
        			
        
        try{
            //���������ð�
            msg.setSentDate(new Date());
             
            InternetAddress from = new InternetAddress() ;
             
             
            from = new InternetAddress("���� �� ����<whatfood2018@gmail.com>");
             
            // �̸��� �߽���
            msg.setFrom(from);
             
             
            // �̸��� ������
            InternetAddress to = new InternetAddress(id);
            msg.setRecipient(Message.RecipientType.TO, to);
             
            // �̸��� ����
            msg.setSubject("���� �� ����, �ӽ� ��й�ȣ �߼�.", "UTF-8");
             
            // �̸��� ���� 
            msg.setText(MainText, "UTF-8");
             
            // �̸��� ��� 
            msg.setHeader("content-Type", "text/html");
             
            //���Ϻ�����
            javax.mail.Transport.send(msg);
             
        }catch (AddressException addr_e) {
            addr_e.printStackTrace();
        }catch (MessagingException msg_e) {
            msg_e.printStackTrace();
        }
    }
    
    public String getRandomString(int length)
    {
      StringBuffer buffer = new StringBuffer();
      Random random = new Random();
     
      String chars[] = 
        "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,0,1,2,3,4,5,6,7,8,9".split(",");
     
      for (int i=0 ; i<length ; i++)
      {
        buffer.append(chars[random.nextInt(chars.length)]);
      }
      return buffer.toString();
    }
 
}
 
 
