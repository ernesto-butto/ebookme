package com.catwizard.controllers;

import com.catwizard.domain.BlogArticle;
import com.catwizard.service.RecommendedArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by poolebu on 2/17/16.
 */
@CrossOrigin
@RestController
@RequestMapping("articleList")
public class ArticleController {

    @Autowired
    RecommendedArticleService recommendedArticleService;

    @RequestMapping(value = "/getList",
               method = RequestMethod.GET,
               produces = "application/json")
    public ArrayList<BlogArticle> getList(){

        return recommendedArticleService.getArticles();

    }


}
