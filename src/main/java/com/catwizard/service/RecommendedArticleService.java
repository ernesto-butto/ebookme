package com.catwizard.service;

import com.catwizard.domain.BlogArticle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by poolebu on 2/17/16.
 */
@Service
public class RecommendedArticleService {


    public static final String MARIA_POPOVA = "Maria Popova";
    public static final String LIVING = "Living";
    public static final String LOVE = "Love";
    private static final String INSPIRING = "Inspiring";
    public static final String MELYSSA_GRIFFIN = "Melyssa Griffin";
    private static final String PRODUCTIVIY = "Productivity";
    public static final String TIM_FERRISS = "Tim Ferriss";
    public static final String PRACTICAL_PHILOSOPHY = "Practical Philosophy";
    public static final String MENTAL_PERFORMANCE = "Mental Performance";
    public static final String ENTREPRENEURSHIP = "Entrepreneurship";
    public static final String PHYSICAL_PERFORMANCE = "Physical Performance";
    public static final String SETH_GODIN = "Seth Godin";
    public static final String NEW_PARADIGMA = "New Paradigma";

    public ArrayList<BlogArticle> getArticles(){



        ArrayList<BlogArticle> articleList = new ArrayList<BlogArticle>();

        // Title, url, author, category

        // POPOVA
        articleList.add(new BlogArticle(
                "Friedrich Nietzsche on Why a Fulfilling Life Requires Embracing Rather than Running from Difficulty",
                "https://www.brainpickings.org/2014/10/15/nietzsche-on-difficulty/",
                MARIA_POPOVA,
                LIVING));


        articleList.add(new BlogArticle("An Antidote to the Age of Anxiety: Alan Watts on Happiness and How to Live with Presence",
                "https://www.brainpickings.org/2014/01/06/alan-watts-wisdom-of-insecurity-1/",
                MARIA_POPOVA,
                LIVING));


        articleList.add(new BlogArticle(
                "Fixed vs. Growth: The Two Basic Mindsets That Shape Our Lives",
                "https://www.brainpickings.org/2014/01/29/carol-dweck-mindset/",
                MARIA_POPOVA,
                LIVING));

        articleList.add(new BlogArticle(
                "How to Love: Legendary Zen Buddhist Teacher Thich Nhat Hanh on Mastering the Art of 'Interbeing'",
                "https://www.brainpickings.org/2015/03/31/how-to-love-thich-nhat-hanh/",
                MARIA_POPOVA,
                LOVE));

        //  Tim Ferris
        articleList.add(new BlogArticle(
                "The Not-To-Do List: 9 Habits to Stop Now",
                "http://fourhourworkweek.com/2007/08/16/the-not-to-do-list-9-habits-to-stop-now/",
                TIM_FERRISS,
                PRODUCTIVIY));

        articleList.add(new BlogArticle(
                "How to Use Philosophy as a Personal Operating System: From Seneca to Musashi",
                "http://fourhourworkweek.com/2011/05/18/philosophy-as-a-personal-operating-system-from-seneca-to-musashi/",
                TIM_FERRISS,
                PRACTICAL_PHILOSOPHY));

        articleList.add(new BlogArticle(
                "You Are What You Read: 14 Thought Leaders Share Their Bookshelves",
                "http://fourhourworkweek.com/2013/10/21/you-are-what-you-read-14-thought-leaders-share-their-bookshelves/",
                TIM_FERRISS,
                MENTAL_PERFORMANCE));

        articleList.add(new BlogArticle(
                "How to Create a Million-Dollar Business This Weekend",
                "http://fourhourworkweek.com/2011/09/24/how-to-create-a-million-dollar-business-this-weekend-examples-appsumo-mint-chihuahuas/",
                TIM_FERRISS,
                ENTREPRENEURSHIP));

        articleList.add(new BlogArticle(
                "Hacking Kickstarter: How to Raise $100,000 in 10 Days",
                "http://fourhourworkweek.com/2012/12/18/hacking-kickstarter-how-to-raise-100000-in-10-days-includes-successful-templates-e-mails-etc/",
                TIM_FERRISS,
                ENTREPRENEURSHIP));

        articleList.add(new BlogArticle(
                "How to Lose 20 lbs. of Fat in 30 Days… Without Doing Any Exercise",
                "http://fourhourworkweek.com/2007/04/06/how-to-lose-20-lbs-of-fat-in-30-days-without-doing-any-exercise/",
                TIM_FERRISS,
                PHYSICAL_PERFORMANCE));

        // Seth Godin
        articleList.add(new BlogArticle(
                "The future of the library",
                "http://sethgodin.typepad.com/seths_blog/2011/05/the-future-of-the-library.html",
                SETH_GODIN,
                NEW_PARADIGMA));

        articleList.add(new BlogArticle(
                "Fear of bad ideas",
                "http://sethgodin.typepad.com/seths_blog/2009/12/fear-of-bad-ideas.html",
                SETH_GODIN,
                ENTREPRENEURSHIP));

        articleList.add(new BlogArticle(
                "Reject the tyranny of being picked: pick yourself",
                "http://sethgodin.typepad.com/seths_blog/2011/03/reject-the-tyranny-of-being-picked-pick-yourself.html",
                SETH_GODIN,
                ENTREPRENEURSHIP));

        articleList.add(new BlogArticle(
                "What investors want",
                "http://sethgodin.typepad.com/seths_blog/2016/02/what-investors-want.html",
                SETH_GODIN,
                ENTREPRENEURSHIP));

        articleList.add(new BlogArticle(
                "The triumph of coal marketing",
                "http://sethgodin.typepad.com/seths_blog/2011/03/the-triumph-of-coal-marketing.html",
                SETH_GODIN,
                ENTREPRENEURSHIP));



        // HUMANS OF NEW YORK
        articleList.add(new BlogArticle(
                "12 of the Best “Humans of New York” Posts",
                "http://thenectarcollective.com/best-humans-of-new-york/",
                MELYSSA_GRIFFIN,
                INSPIRING));



        return articleList;
    }

}
