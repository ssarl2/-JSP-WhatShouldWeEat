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
        //출처 : http://fruitdev.tistory.com/15
        Properties p = System.getProperties();
        p.put("mail.smtp.starttls.enable", "true");     // gmail은 무조건 true 고정
        p.put("mail.smtp.host", "smtp.gmail.com");      // smtp 서버 주소
        p.put("mail.smtp.auth","true");                 // gmail은 무조건 true 고정
        p.put("mail.smtp.port", "587");                 // gmail 포트
           
        Authenticator auth = new MyAuthentication();
         
        //session 생성 및  MimeMessage생성
        Session session = Session.getDefaultInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);
        String MainText = 
        			"안녕하세요. "+ id +" 님, " +
        			"오늘 뭐 먹지의 관리자입니다.<br>" +
        			"임시 비밀번호는 " + tmpw + " 입니다.<br>" +
        			"입력 후 회원정보 수정으로 비밀번호 재설정 하시기 바랍니다.";
        			
        
        try{
            //편지보낸시간
            msg.setSentDate(new Date());
             
            InternetAddress from = new InternetAddress() ;
             
             
            from = new InternetAddress("오늘 뭐 먹지<whatfood2018@gmail.com>");
             
            // 이메일 발신자
            msg.setFrom(from);
             
             
            // 이메일 수신자
            InternetAddress to = new InternetAddress(id);
            msg.setRecipient(Message.RecipientType.TO, to);
             
            // 이메일 제목
            msg.setSubject("오늘 뭐 먹지, 임시 비밀번호 발송.", "UTF-8");
             
            // 이메일 내용 
            msg.setText(MainText, "UTF-8");
             
            // 이메일 헤더 
            msg.setHeader("content-Type", "text/html");
             
            //메일보내기
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
 
 
