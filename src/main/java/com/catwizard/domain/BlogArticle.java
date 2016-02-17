package com.catwizard.domain;

/**
 * Created by poolebu on 2/17/16.
 */
public class BlogArticle {

    String title;
    String url;
    String author;
    String category;

    public BlogArticle(String title, String url, String author, String category) {
        this.title = title;
        this.url = url;
        this.author = author;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
