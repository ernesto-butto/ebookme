package com.catwizard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by poolebu on 1/8/16.
 */
@Service
public class EbookConversionService {

    private String EglueKey = "xxx";
    private String ebookUrlService = "https://ebookglue.com/convert";

    private final Logger log = LoggerFactory.getLogger(EbookConversionService.class);

    private final String USER_AGENT = "Mozilla/5.0";

    public String getEglueKey() {
        return EglueKey;
    }

    public void setEglueKey(String eglueKey) {
        this.EglueKey = eglueKey;
    }


    public File sendGetToCalibreServer(String urlToConvert, String format, String fileName) throws Exception {

        // http://ec2-54-84-106-242.compute-1.amazonaws.com:8080/convert?htmlUrl=http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html&title=madeupTitle&mobi

        //http://jessewarden.com/2008/11/agile-chronicles-1-stressful.html
        String host = "http://ec2-54-84-106-242.compute-1.amazonaws.com:8080";
        String url = host + "/convert?htmlUrl="+urlToConvert+"&title="+fileName+"&"+format;

        log.info("Sending request for convertion to " + url);

        URL obj = new URL(url);
        HttpURLConnection openConnection = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        openConnection.setRequestMethod("GET");

        //add request header
        openConnection.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = openConnection.getResponseCode();
        log.info("\nSending 'GET' request to URL : " + url);
        log.info("Response Code : " + responseCode);

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

            log.info("Done writing to file "+fileName);

        } catch (IOException e) {

            log.error(e.getMessage());

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

    public File sendGetToEglueService(String urlToConvert, String format, String fileName) throws Exception {

        String url = ebookUrlService + "?token="+ EglueKey + "&url="+urlToConvert+"&format="+format;

        URL obj = new URL(url);
        HttpURLConnection openConnection = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        openConnection.setRequestMethod("GET");

        //add request header
        openConnection.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = openConnection.getResponseCode();
        log.info("\nSending 'GET' request to URL : " + url);
        log.info("Response Code : " + responseCode);

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

            log.info("Done writing to file "+fileName);

        } catch (IOException e) {

            log.error(e.getMessage());

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
