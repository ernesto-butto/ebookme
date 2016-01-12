package com.catwizard.service;

import com.catwizard.MainApplication;
import org.apache.commons.mail.EmailException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;

/**
 * Created by poolebu on 1/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class)
@WebAppConfiguration
public class HtmlServiceTest {

    @Autowired
    HtmlService htmlService;

    @Autowired
    EmailService emailService;

    String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html";
    String outputFormat = "MOBI";

    @Test
    @Ignore
    public void getHtmlContentTest(){

        String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html";

        String htmlToConvert = htmlService.getHtmlContent(urlToConvert);

        Assert.assertTrue(!htmlToConvert.isEmpty());
    }

    @Test
    public void getHtmlContentAndSendToEmail(){

        HtmlService htmlService = new HtmlService();

        String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html";

        String htmlContent = htmlService.getHtmlContent(urlToConvert);

        File file = htmlService.saveHtmlContentToFile(htmlContent, "ebookContent");

        try {

            emailService.sendMail("htmlContent test","Trying stuff with this content",file,"poolebu@gmail.com");

        } catch (EmailException e) {

            e.printStackTrace();

        }

    }



}
