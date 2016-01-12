package com.catwizard.service;

import com.catwizard.MainApplication;
import org.apache.commons.mail.EmailException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;

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
        String content="Hello Ernesto, this is a good email, please dont reject me, hope you like it";
        String subject = "Hello Ernesto ";

        File file = new File("/Users/poolebu/Desktop/book2.mobi");

        try {
            emailService.sendMail(subject,content,file,toEmail);
        } catch (EmailException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void sendEmailWithHtmlAttachment(){

        HtmlService htmlService = new HtmlService();

        String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html";

        String htmlContent = htmlService.getHtmlContent(urlToConvert);

        File file = htmlService.saveHtmlContentToFile(htmlContent,"ebookContent");


        try {
            emailService.sendMail("htmlContent test","Trying stuff with this content",file,"poolebu@gmail.com");
        } catch (EmailException e) {
            e.printStackTrace();
        }


    }

}

