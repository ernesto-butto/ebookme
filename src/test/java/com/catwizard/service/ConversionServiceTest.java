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
 * Created by poolebu on 1/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class)
@WebAppConfiguration
public class ConversionServiceTest {

    String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-2-code-refactoring.html";
    String outputFormat = "PDF";

    @Test
    @Ignore
    public void sendGetToEglueServiceTest(){

        EbookConversionService ebookGlueService = new EbookConversionService();
        File file=null;
        try {

            file=  ebookGlueService.sendGetToEglueService(urlToConvert, outputFormat, "title");

        } catch (Exception e) {

            e.printStackTrace();

        }

        Assert.assertTrue(file.exists());

    }

    @Test
    public void sendGetToCalibreServerTest(){

        EbookConversionService ebookGlueService = new EbookConversionService();
        File file=null;
        try {

            file=  ebookGlueService.sendGetToCalibreServer(urlToConvert, outputFormat, "Code Refactoring");

        } catch (Exception e) {

            e.printStackTrace();

        }

        Assert.assertTrue(file.exists());

    }
}
