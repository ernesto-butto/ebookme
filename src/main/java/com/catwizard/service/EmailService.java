package com.catwizard.service;

import org.apache.commons.mail.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.File;
import java.util.Properties;

/**
 * Created by poolebu on 1/8/16.
 */
public class EmailService {

	private JavaMailSender mailSender;
	private SimpleMailMessage simpleMailMessage;

	final String username = "ebookme2@gmail.com";
	final String password = "SyVav5UB";


	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String subject, String content,File fileAttachment,String recepient) throws EmailException {


		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();

		attachment.setPath(fileAttachment.getPath());
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
//		attachment.setDescription("Ebook for "+recepient);
//		attachment.setName(recepient);


		//
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(username, password));
		email.setSSL(true);
		email.setFrom(username);
		email.setSubject(subject);
		email.setMsg(content);
		email.addTo(recepient);

		email.attach(attachment);


		email.send();
		//


	}
}
