package food.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

class MyAuthentication extends Authenticator {
    
    PasswordAuthentication pa;
    
 
    public MyAuthentication(){
         
        String id = "whatfood2018@gmail.com";       // ���� ID
        String pw = "whatfood1!";          // ���� ��й�ȣ
 
        // ID�� ��й�ȣ�� �Է��Ѵ�.
        pa = new PasswordAuthentication(id, pw);
      
    }
 
    // �ý��ۿ��� ����ϴ� ��������
    public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
}
