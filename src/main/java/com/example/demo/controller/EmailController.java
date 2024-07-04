package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Service.EmailService;
import com.example.demo.model.rerquest.EmailRrequest;
import com.example.demo.model.response.Email;
import jakarta.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {
    @Autowired
    private EmailService emailService;
    
    @PostMapping("/send")
    public Email sendEmail(@RequestBody EmailRrequest emailRequest,@RequestParam("file") MultipartFile file) throws MessagingException {
        return emailService.sendEmail(emailRequest.getSender(), emailRequest.getRecipient(), emailRequest.getSubject(), emailRequest.getBody(),file);
    }

    @GetMapping("/{recipient}")
    public List<Email> getEmailsForRecipient(@PathVariable String recipient) {
        return emailService.getEmailsForRecipient(recipient);
    }
}

