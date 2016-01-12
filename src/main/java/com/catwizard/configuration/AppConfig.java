package com.catwizard.configuration;

import com.catwizard.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger log = LoggerFactory.getLogger(AppConfig.class);


    @Bean
    public EmailService loadGmailConfiguration(){

        emailService.setUsername(env.getProperty("email"));
        emailService.setPassword(env.getProperty("password"));

        log.info("loading user and login gmail password");

        return emailService;

    }
}
