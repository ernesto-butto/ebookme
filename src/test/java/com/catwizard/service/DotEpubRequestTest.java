package com.catwizard.service;

import com.catwizard.MainApplication;
import junit.framework.Assert;
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
public class DotEpubRequestTest {

    String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html";
    String outputFormat = "MOBI";


    @Test
    @Ignore
    public void sendRequestTest(){

        DotEpubRequest dotEpubRequest = new DotEpubRequest();

        File result = null;
        try {
            result = dotEpubRequest.sendRequestForConversionDotEpub("<b>hola</b>", urlToConvert, outputFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Assert.assertTrue(!result.exists());

    }

    @Test
    @Ignore
    public void getHtmlContentTest(){

        String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html";

        DotEpubRequest dotEpubRequest = new DotEpubRequest();

        String htmlToConvert = dotEpubRequest.getHtmlContent(urlToConvert);

        Assert.assertTrue(!htmlToConvert.isEmpty());
    }

    public void getHtmlContentAndSendToEmail(){


        String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html";

        DotEpubRequest dotEpubRequest = new DotEpubRequest();

        String htmlToConvert = dotEpubRequest.getHtmlContent(urlToConvert);


    }

    @Test
    //@Ignore
    public void getHtmlContentAndConvertWitDotEpubTest(){


        DotEpubRequest dotEpubRequest = new DotEpubRequest();

        String htmlToConvert = dotEpubRequest.getHtmlContent(urlToConvert);

        File result = null;
        try {
            result = dotEpubRequest.sendRequestForConversionDotEpub(htmlToConvert, urlToConvert, outputFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Assert.assertTrue(result.exists());


    }

}
