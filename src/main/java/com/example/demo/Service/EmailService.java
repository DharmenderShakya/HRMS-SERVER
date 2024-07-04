package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Repository.EmailRepository;
import com.example.demo.model.response.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.util.Date;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;
    
//    @Autowired
	private JavaMailSender javaMailSender;

    public Email sendEmail(String sender, String recipient, String subject, String body,MultipartFile file) throws MessagingException {
    	MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setTo(recipient);
		String message = "<div style='font-family: Arial, sans-serif;'>"
                + "<p><strong>From:</strong> " + sender + "</p>"
                + "<p><strong>To:</strong> " + recipient + "</p>"
                + "<p><strong>Subject:</strong> " + subject + "</p>"
                + "<br>"
                + "<div style='background-color: #f5f5f5; padding: 10px; border-radius: 5px;'>"
                + body
                + "</div>"
                + "</div>";
		mimeMessageHelper.setText(message);
		mimeMessageHelper.setFrom(sender);
		mimeMessageHelper.addAttachment(file.getName(),file);
		javaMailSender.send(mimeMessage);
		
        Email email = new Email();
        email.setSender(sender);
        email.setRecipient(recipient);
        email.setSubject(subject);
        email.setBody(body);
        email.setSentAt(new Date());
        return emailRepository.save(email);
    }

    public List<Email> getEmailsForRecipient(String recipient) {
        return emailRepository.findByRecipient(recipient);
    }
}
