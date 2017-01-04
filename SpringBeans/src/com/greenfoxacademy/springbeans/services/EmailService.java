package com.greenfoxacademy.springbeans.services;

/**
 * Created by posam on 2016-12-21.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class EmailService implements MessageService {

    public boolean sendMessage(String msg, String rec) {
        System.out.println("Email Sent to " + rec + " with Message=" + msg);
        return true;
    }

}
