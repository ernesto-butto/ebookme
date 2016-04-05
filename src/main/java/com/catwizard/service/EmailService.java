package com.catwizard.service;

import org.apache.commons.mail.*;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by poolebu on 1/8/16.
 */
@Service
public class EmailService {


    public String username = "xxx";
    public String password = "xxx";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void sendMail(String subject, String content,File fileAttachment,String recepient) {


        // Create the attachment
        EmailAttachment attachment = new EmailAttachment();

        attachment.setPath(fileAttachment.getPath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);

        try {
            // Populate message
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(username, password));
            email.setSSL(true);
            email.setFrom(username);

            email.setSubject(subject);

            VelocityEngine velocity = new VelocityEngine();
            velocity.init();

            HashMap<String,Object> items =  new HashMap();

            items.put("recepient",recepient);

            String text = VelocityEngineUtils.mergeTemplateIntoString(velocity,"src/main/resources/velocity/emailEbookmeContent.vm","UTF-8",items);



            email.setMsg(text);
            email.addTo(recepient);

            // Attach
            email.attach(attachment);

            // Send
            email.send();

        }catch (Exception e){

            e.printStackTrace();
        }

    }
}
