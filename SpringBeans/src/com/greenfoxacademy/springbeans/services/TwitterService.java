package com.greenfoxacademy.springbeans.services;

/**
 * Created by posam on 2016-12-21.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */

public class TwitterService implements MessageService {

    public boolean sendMessage(String msg, String rec) {
        System.out.println("Twitter message Sent to " + rec + " with Message=" + msg);
        return true;
    }

}