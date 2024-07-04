package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.Properties;

@Service
public class EmailReceiverService {

    @Value("${mail.imap.host}")
    private String mailHost;

    @Value("${mail.imap.port}")
    private int mailPort;

    @Value("${mail.imap.username}")
    private String username;

    @Value("${mail.impa.password}")
    private String password;

    @Value("${mail.imap.protocol}")
    private String protocol;

    public void receiveEmails() {
        Properties properties = new Properties();
        properties.put("mail.store.protocol", protocol);
        properties.put("mail.imap.host", mailHost);
        properties.put("mail.imap.port", mailPort);
        properties.put("mail.imap.ssl.enable", "true");

        Session emailSession = Session.getDefaultInstance(properties);

        try {
            Store store = emailSession.getStore(protocol);
            store.connect(mailHost, username, password);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            
            Message[] messages = emailFolder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            for (Message message : messages) {
                System.out.println("Email Subject: " + message.getSubject());
                System.out.println("Email Content: " + message.getContent().toString());
            }

            emailFolder.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}