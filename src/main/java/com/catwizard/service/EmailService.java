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
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
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

    public void sendMail(String subject,File fileAttachment,String recipient, HashMap<String,Object> itemsContent) {


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
            email.setFrom(username,"EbookMe");

            email.setSubject(subject);

            email.addTo(recipient);

            VelocityEngine velocity = new VelocityEngine();
            velocity.init();

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            String text = VelocityEngineUtils.mergeTemplateIntoString(velocity,"src/main/resources/velocity/emailEbookmeContent.vm","UTF-8",itemsContent);

            messageBodyPart.setContent(text, "text/html");

            MimeMultipart multipart = new MimeMultipart();

            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();

            javax.activation.DataSource source = new FileDataSource(attachment.getPath());

            messageBodyPart.setDataHandler(new DataHandler(source));

            messageBodyPart.setFileName(attachment.getPath());

            multipart.addBodyPart(messageBodyPart);

            email.setContent(multipart);




            // Send
            email.send();

        }catch (Exception e){

            e.printStackTrace();
        }

    }
}
