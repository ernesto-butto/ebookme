package com.catwizard.service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by poolebu on 1/7/16.
 */
public class HtmlService {


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

    public File saveHtmlContentToFile(String htmlContent,String filename){
        File file = null;
        try {


            file = new File("./"+filename+".html");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(htmlContent);
            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;

    }


}
