package com.greenfoxacademy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by posam on 2017-01-05.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.greenfoxacademy")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
//        resolver.setFallbackPageable(new PageRequest(1, 10));
        resolver.setOneIndexedParameters(true);
//        resolver.setPageParameterName("page");
//        resolver.setPageParameterName("size");
        argumentResolvers.add(resolver);
        super.addArgumentResolvers(argumentResolvers);
    }

}
