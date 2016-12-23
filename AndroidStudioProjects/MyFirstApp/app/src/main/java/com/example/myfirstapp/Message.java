package com.example.myfirstapp;

/**
 * Created by posam on 2016-12-23.
 */

class Message {
    private String body;
    private String username;
    private String created_at = "1995/05/24";

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }


    Message(String body, String username) {
        this.body = body;
        this.username = username;
    }
}
