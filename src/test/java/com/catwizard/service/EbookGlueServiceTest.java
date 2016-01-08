package com.catwizard.service;

import com.catwizard.MainApplication;
import org.junit.Assert;
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
public class EbookGlueServiceTest {

    String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html";
    String outputFormat = "MOBI";

    @Test
    public void sendGetTest(){

        EbookGlueService ebookGlueService = new EbookGlueService();
        File file=null;
        try {
           file=  ebookGlueService.sendGet(urlToConvert,outputFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertTrue(file.exists());

    }
}
