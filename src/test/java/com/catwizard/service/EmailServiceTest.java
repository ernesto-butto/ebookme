package com.catwizard.service;

import com.catwizard.MainApplication;
import org.apache.commons.mail.EmailException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;

/**
 * Created by poolebu on 1/8/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class)
@WebAppConfiguration
public class EmailServiceTest {

    @Test
    public void sendEmailTest(){

        EmailService emailService = new EmailService();
        String toEmail="poolebu@gmail.com";
        String content="Hello Ernesto, this is a good email, please dont reject me, hope you like it";
        String subject = "Hello Ernesto ";

        File file = new File("/Users/poolebu/Desktop/book2.mobi");

        try {
            emailService.sendMail(subject,content,file,toEmail);
        } catch (EmailException e) {
            e.printStackTrace();
        }


    }

}

