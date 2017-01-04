package com.greenfoxacademy.springbeans.configuration;

/**
 * Created by posam on 2016-12-21.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */

import com.greenfoxacademy.springbeans.services.MessageService;
import com.greenfoxacademy.springbeans.services.TwitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.greenfoxacademy.springbeans.consumer"})
public class DITwitterConfiguration {

    @Bean
    public MessageService getMessageService() {
        return new TwitterService();
    }
}
