package food.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

class MyAuthentication extends Authenticator {
    
    PasswordAuthentication pa;
    
 
    public MyAuthentication(){
         
        String id = "whatfood2018@gmail.com";       // 구글 ID
        String pw = "whatfood1!";          // 구글 비밀번호
 
        // ID와 비밀번호를 입력한다.
        pa = new PasswordAuthentication(id, pw);
      
    }
 
    // 시스템에서 사용하는 인증정보
    public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
}
