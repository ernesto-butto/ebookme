package com.catwizard.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by poolebu on 1/11/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertRequest {

    private String title;
    private String url;
    private String format;
    private String email;
    private String author;


    public ConvertRequest() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ConvertRequest{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", format='" + format + '\'' +
                ", email='" + email + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
