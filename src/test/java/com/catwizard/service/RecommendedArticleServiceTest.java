package com.catwizard.service;

import com.catwizard.MainApplication;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by poolebu on 2/17/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class)
@WebAppConfiguration
public class RecommendedArticleServiceTest {

    @Autowired
    RecommendedArticleService recommendedArticleService;

    @Test
    public void getArticleListTest(){

        Assert.assertFalse(recommendedArticleService.getArticles().isEmpty());

    }


}
