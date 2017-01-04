package com.greenfoxacademy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by posam on 2017-01-04.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String content;
    int score;
}
