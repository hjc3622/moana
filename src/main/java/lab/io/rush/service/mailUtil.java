package lab.io.rush.service;

import java.util.List;
import java.util.Properties;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class mailUtil {

    private MailSender mailSender;  
    private SimpleMailMessage simpleMailMessage;  
      
    //Spring 依赖注入  
    public void setMailSender(MailSender mailSender) {  
        this.mailSender = mailSender;  
    }  
      
    //Spring 依赖注入  
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {  
        this.simpleMailMessage = simpleMailMessage;  
    }  
    /** 
     * 单发 
     * 
     * @param recipient 收件人 
     * @param subject 主题 
     * @param content 内容 
     */  
    public void send(String recipient,String subject,String content){  
        simpleMailMessage.setTo(recipient);  
        simpleMailMessage.setSubject(subject);  
        simpleMailMessage.setText(content);  
        mailSender.send(simpleMailMessage);  
    }  
      
    /** 
     * 群发 
     * 
     * @param recipients 收件人 
     * @param subject 主题 
     * @param content 内容 
     */  
    public void send(List<String> recipients,String subject,String content){  
        simpleMailMessage.setTo(recipients.toArray(new String[recipients.size()]));  
        simpleMailMessage.setSubject(subject);  
        simpleMailMessage.setText(content);  
        mailSender.send(simpleMailMessage);  
    }  
}
