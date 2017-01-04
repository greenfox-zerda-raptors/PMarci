package com.greenfoxacademy.springbeans;

/**
 * Created by posam on 2016-12-21.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class HelloWorldConfig {

    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }

    @Scope("prototype")
    @Bean
    public WithFries withFries() {
        return new WithFries();
    }

    @Scope("prototype")
    @Bean
    public WithFries withFries(Boolean salt) {
        return new WithFries(salt);
    }

}
