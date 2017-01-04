package com.greenfoxacademy.springbeans.configuration;

/**
 * Created by posam on 2016-12-21.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */

import com.greenfoxacademy.springbeans.services.EmailService;
import com.greenfoxacademy.springbeans.services.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.greenfoxacademy.springbeans.consumer"})
public class DIConfiguration {
    int EMAIL_SEERVICE = 0;
    int TWITTER_SEERVICE = 1;

    @Bean
    public MessageService getMessageService() {
        return new EmailService();
    }
}