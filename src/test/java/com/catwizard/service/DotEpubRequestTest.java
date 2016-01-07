package com.catwizard.service;

import com.catwizard.MainApplication;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by poolebu on 1/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class)
@WebAppConfiguration
public class DotEpubRequestTest {

    @Test
    public void sendRequestTest(){

        DotEpubRequest dotEpubRequest = new DotEpubRequest();

        String result = "";
        try {
            result = dotEpubRequest.sendRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Assert.assertTrue(!result.isEmpty());

    }
}
