package com.catwizard.controllers;

import com.catwizard.domain.ConvertRequest;
import com.catwizard.domain.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by poolebu on 1/7/16.
 */
@RestController
public class ConverterController {

    private final Logger log = LoggerFactory.getLogger(ConverterController.class);

    @RequestMapping(value = "/convert",
            method = RequestMethod.POST,
            produces = "application/json")
    @ResponseBody
        public RestResponse convert(@RequestBody ConvertRequest convertRequest) {

        log.info("Got convert request with "+convertRequest.toString());
        RestResponse restResponse = new RestResponse("Got request "+ convertRequest.toString());

        return restResponse;

    }

}
