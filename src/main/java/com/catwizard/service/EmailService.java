package com.catwizard.service;

import org.apache.commons.mail.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Service;

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

	public void sendMail(String subject, String content,File fileAttachment,String recepient) throws EmailException {


		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();

		attachment.setPath(fileAttachment.getPath());
		attachment.setDisposition(EmailAttachment.ATTACHMENT);


		// Populate message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(username, password));
		email.setSSL(true);
		email.setFrom(username);
		email.setSubject(subject);
		email.setMsg(content);
		email.addTo(recepient);

		// Attach
		email.attach(attachment);

		// Send
		email.send();


	}
}
