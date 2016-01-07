package com.catwizard.controllers;

import com.catwizard.domain.RestResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by poolebu on 1/7/16.
 */
@RestController
public class ConverterController {

    @RequestMapping("/convert")
        public RestResponse convert(@RequestParam(value="name", defaultValue="World",required = false) String name) {

        RestResponse restResponse = new RestResponse("Test response");


        return restResponse;

    }

}
