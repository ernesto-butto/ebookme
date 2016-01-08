package com.catwizard.service;

import com.catwizard.MainApplication;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html";
    String outputFormat = "MOBI";




    @Test
    @Ignore
    public void getHtmlContentTest(){

        String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html";

        HtmlService htmlService = new HtmlService();

        String htmlToConvert = htmlService.getHtmlContent(urlToConvert);

        Assert.assertTrue(!htmlToConvert.isEmpty());
    }

    @Test
    public void getHtmlContentAndSendToEmail(){


        String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html";

        HtmlService htmlService = new HtmlService();

        String htmlToConvert = htmlService.getHtmlContent(urlToConvert);


    }



}
