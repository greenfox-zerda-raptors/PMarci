package com.greenfoxacademy.services;

import com.greenfoxacademy.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by posam on 2017-01-04.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */


public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findTop10ByOrderByScoreDesc();
}
