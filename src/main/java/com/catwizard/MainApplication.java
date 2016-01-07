package com.catwizard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class MainApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "Hello Cindy And Ernesto from Heroku! with github integration :>";
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
