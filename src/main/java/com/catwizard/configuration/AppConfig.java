package com.catwizard.configuration;

import com.catwizard.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.inject.Inject;


/**
 * Created by poolebu on 1/11/16.
 */
@Configuration
public class AppConfig {

    @Inject
    Environment env;

    @Autowired
    EmailService emailService;

    @Bean
    public EmailService loadGmailConfiguration(){

        emailService.setUsername(env.getProperty("email"));
        emailService.setPassword(env.getProperty("password"));

        return emailService;

    }
}
