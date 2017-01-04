package com.greenfoxacademy.springbeans.test;

/**
 * Created by posam on 2016-12-21.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */

import com.greenfoxacademy.springbeans.configuration.DIConfiguration;
import com.greenfoxacademy.springbeans.consumer.MyApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        MyApplication app = context.getBean(MyApplication.class);
        app.processMessage("Hi Pankaj", "pankaj@abc.com");
        //close the context
        context.close();
    }

}
