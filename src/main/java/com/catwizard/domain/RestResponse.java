package com.catwizard.domain;

/**
 * Created by poolebu on 1/7/16.
 */
public class RestResponse {

    String response;

    public RestResponse() {
    }

    public RestResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
