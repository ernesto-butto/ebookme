package com.catwizard.controllers;

import com.catwizard.domain.ConvertRequest;
import com.catwizard.domain.RestResponse;
import com.catwizard.service.EbookConversionService;
import com.catwizard.service.EmailService;
import com.catwizard.service.HtmlService;
import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

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

        if (convertRequest.getFormat().equalsIgnoreCase("HTML")){

            htmlConvertAndSendEmail(convertRequest, restResponse);

        }else{

            File file=null;

            try {
                file=  ebookGlueService.sendGetToCalibreServer(convertRequest.getUrl(), convertRequest.getFormat(), convertRequest.getTitle() + "." + convertRequest.getFormat());

                emailService.sendMail("You got content "+convertRequest.getEmail(),
                                    "Hello, this is the result of your ebookme request",
                                    file,
                                    convertRequest.getEmail());
            } catch (Exception e) {

                return new ResponseEntity<RestResponse>(restResponse,HttpStatus.INTERNAL_SERVER_ERROR);

            }

            String response = "Fomat "+ convertRequest.getFormat()+" still not soported";

            log.info(response);

            restResponse.setResponse(response);

        }

        return new ResponseEntity<RestResponse>(restResponse, HttpStatus.OK);

    }

    private void htmlConvertAndSendEmail(@RequestBody ConvertRequest convertRequest, RestResponse restResponse) {

        String htmlContent = htmlService.getHtmlContent(convertRequest.getUrl());

        File file = htmlService.saveHtmlContentToFile(htmlContent, convertRequest.getTitle());

        try {

            emailService.sendMail("You got content "+convertRequest.getEmail(),
                    "Hello, this is the result of your ebookme request",
                    file,
                    convertRequest.getEmail());

            restResponse.setResponse("Mail sent succesfully");

        } catch (EmailException e) {

            restResponse.setResponse("Error sending email: "+e.getMessage());

        }
    }


}
