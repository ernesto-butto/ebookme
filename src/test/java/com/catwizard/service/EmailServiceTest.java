package com.catwizard.service;

import com.catwizard.MainApplication;
import com.catwizard.domain.ConvertRequest;
import org.apache.commons.mail.EmailException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.util.HashMap;

/**
 * Created by poolebu on 1/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class)
@WebAppConfiguration
public class EmailServiceTest {

    @Autowired
    EmailService emailService;


    @Test
    @Ignore
    public void sendEmailTest(){

        String toEmail="poolebu@gmail.com";
        String subject = "Hello Ernesto ";

        ConvertRequest  convertRequest = new ConvertRequest();
        convertRequest.setEmail(toEmail);
        convertRequest.setFormat("PDF");
        convertRequest.setTitle("Test Title");
        convertRequest.setUrl("test url");


        HashMap<String,Object> items =  new HashMap();

        items.put("convertRequest",convertRequest);

        File file = new File("/Users/poolebu/Desktop/book2.mobi");

        emailService.sendMail(subject,file,toEmail,items);

    }

    @Test
    public void sendEmailWithHtmlAttachment(){

        HtmlService htmlService = new HtmlService();

        String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html";

        String htmlContent = htmlService.getHtmlContent(urlToConvert);

        File file = htmlService.saveHtmlContentToFile(htmlContent,"ebookContent");

        ConvertRequest  convertRequest = new ConvertRequest();
        convertRequest.setEmail("poolebu@gmail.com");
        convertRequest.setFormat("PDF");
        convertRequest.setTitle("Test Title");
        convertRequest.setUrl("test url");


        HashMap<String,Object> items =  new HashMap();

        items.put("convertRequest",convertRequest);

        emailService.sendMail("htmlContent test",file,"poolebu@gmail.com",items);


    }

}

