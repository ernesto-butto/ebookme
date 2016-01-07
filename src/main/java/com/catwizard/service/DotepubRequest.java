package com.catwizard.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by poolebu on 1/7/16.
 */
public class DotEpubRequest {

    public String sendRequest() throws Exception{

        String urlToConvert = "http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html";
        String dotEpubUrl = "http://dotepub.com/v1/post";


        URL obj = new URL(dotEpubUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");

        String urlParameters = "html=xxx&title=xxx&urlxxx=&format=xxx&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + dotEpubUrl);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


        return response.toString();


    }


}
