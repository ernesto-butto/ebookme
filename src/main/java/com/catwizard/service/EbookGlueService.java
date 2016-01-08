package com.catwizard.service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by poolebu on 1/8/16.
 */
public class EbookGlueService {

    String apiKey = "cfe5hqnhfcq3bez7lgpn24g4qux5ilz4";
    String ebookUrlService = "https://ebookglue.com/convert";
    String fileName= "/Users/poolebu/Desktop/book2.mobi";

    private final String USER_AGENT = "Mozilla/5.0";

    // HTTP GET request

    public File sendGet(String urlToConvert,String format) throws Exception {

        String url = ebookUrlService + "?token="+apiKey + "&url="+urlToConvert+"&format="+format;

        URL obj = new URL(url);
        HttpURLConnection openConnection = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        openConnection.setRequestMethod("GET");

        //add request header
        openConnection.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = openConnection.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
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
