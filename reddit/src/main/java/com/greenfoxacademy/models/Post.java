package com.greenfoxacademy.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotEmpty(message = "Post body can''t be empty!")
    public String content;
    public int score;

    @Temporal(TemporalType.TIMESTAMP)
    public Calendar created;

    @Column
    public long replyTo;

    @Column
    public long threadNr;


    public Post() {
        this.created = Calendar.getInstance();
    }

    public Post(long threadNr, long replyTo) {
        this();
        this.threadNr = threadNr;
        this.replyTo = replyTo;
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
