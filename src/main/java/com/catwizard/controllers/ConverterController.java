package com.catwizard.controllers;

import com.catwizard.domain.ConvertRequest;
import com.catwizard.domain.RestResponse;
import com.catwizard.service.EbookConversionService;
import com.catwizard.service.EmailService;
import com.catwizard.service.HtmlService;
import com.catwizard.service.TitleExtractorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by poolebu on 1/7/16.
 */
@CrossOrigin
@RestController
public class ConverterController {

    private final Logger log = LoggerFactory.getLogger(ConverterController.class);

    @Autowired
    EmailService emailService;

    @Autowired
    HtmlService htmlService;

    @Autowired
    EbookConversionService ebookGlueService;


    @RequestMapping(value = "/convert",
            method = RequestMethod.POST,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<RestResponse> convert(@RequestBody ConvertRequest convertRequest) {

        log.info("Got convert request with "+convertRequest.toString());

        RestResponse restResponse = new RestResponse("Got request "+ convertRequest.toString());

        File fileToSend=null;

        // Get the title from the web page if we got none yet
        if (convertRequest.getTitle().equalsIgnoreCase("ebook_content") || convertRequest.getTitle().isEmpty())
            convertRequest.setTitle(extractTitleFromUrl(convertRequest));


        // If is html, convert and send
        if (convertRequest.getFormat().equalsIgnoreCase("HTML")){

            fileToSend=htmlConvert(convertRequest, restResponse);

            // else, send to calibreServer for conversion
        }else{

            try {


                fileToSend=  ebookGlueService.sendGetToCalibreServer(convertRequest.getUrl(), convertRequest.getFormat(), convertRequest.getTitle());


            } catch (Exception e) {

                return new ResponseEntity<RestResponse>(restResponse,HttpStatus.INTERNAL_SERVER_ERROR);

            }



        }

        String response = "Got it: "+fileToSend.getAbsolutePath();

        log.info(response);

        log.info("Sending email to user :"+ convertRequest.getEmail());

        HashMap<String,Object> items =  new HashMap();

        items.put("convertRequest",convertRequest);


        emailService.sendMail("You got content " + convertRequest.getEmail(),
                fileToSend,
                convertRequest.getEmail(),items);


        restResponse.setResponse(response);

        return new ResponseEntity<RestResponse>(restResponse, HttpStatus.OK);

    }

    private String extractTitleFromUrl(@RequestBody ConvertRequest convertRequest) {

        String title = convertRequest.getTitle();

        try {
            title = TitleExtractorService.getPageTitle(convertRequest.getUrl());
            title = title.trim();
            title = title.substring(0,10);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return title;

    }

    private File htmlConvert(@RequestBody ConvertRequest convertRequest, RestResponse restResponse) {

        String htmlContent = htmlService.getHtmlContent(convertRequest.getUrl());

        File file = htmlService.saveHtmlContentToFile(htmlContent, convertRequest.getTitle());

        return file;

    }


}
