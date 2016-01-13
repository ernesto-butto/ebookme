package com.catwizard.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by poolebu on 1/11/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertRequest {

    String title;
    String url;
    String format;
    String email;


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

    @Override
    public String toString() {
        return "ConvertRequest{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", format='" + format + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
