package com.catwizard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class MainApplication {

    private final Logger log = LoggerFactory.getLogger(MainApplication.class);

    @RequestMapping("/")
    @ResponseBody
    String home() {

        log.debug("Connection received ");
        return "Ebook me is Running :)";
    }

    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class, args);
    }
}
