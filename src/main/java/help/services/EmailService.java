package help.services;

import help.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("mailService")
public interface EmailService {


//    void sendText(String from, String to, String subject, String body);
//
    void sendHTML(String from, String to, String subject, String body) throws IOException;
}