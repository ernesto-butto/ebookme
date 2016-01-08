package com.catwizard.service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by poolebu on 1/7/16.
 */
public class DotEpubService {



    public String getHtmlContent(String targetUrl){

        String content = null;

        URLConnection connection = null;

        try {

            connection =  new URL(targetUrl).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();

        }catch ( Exception ex ) {

            ex.printStackTrace();

        }

        return content;

    }

    public File sendRequestForConversionDotEpub(String htmlToConvert, String originalSiteUrl, String format) throws Exception{

        String dotEpubUrl = "http://dotepub.com/v1/post";
        String title = "TestTitle";
        String fileName="/Users/poolebu/Desktop/book.mobi";


        URL url = new URL(dotEpubUrl);
        HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();

        openConnection.setRequestMethod("POST");

        String urlParameters = "html="+htmlToConvert+
                "&title="+originalSiteUrl+
                "&url="+originalSiteUrl+
                "&format="+format;

        // Send post request
        openConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(openConnection.getOutputStream());
        dataOutputStream.writeBytes(urlParameters);
        dataOutputStream.flush();
        dataOutputStream.close();

        int responseCode = openConnection.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + dotEpubUrl);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);


        // Dealing with the response
        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {

            inputStream = openConnection.getInputStream();

            outputStream = new FileOutputStream(fileName);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            System.out.println("Done!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    // outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


        return new File(fileName);


    }


}
