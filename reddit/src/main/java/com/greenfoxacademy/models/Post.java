package com.greenfoxacademy.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

/**
 * Created by posam on 2017-01-04.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @NotNull
    @Size(min = 1, message = "Post body can''t be empty!")
    public String content;
    public int score;

    @Temporal(TemporalType.TIMESTAMP)
    public Calendar created;

    public Post() {
        this.created = Calendar.getInstance();
    }

    public Post increment() {
        this.score++;
        return this;
    }

    public Post decrement() {
        this.score--;
        return this;
    }
}
