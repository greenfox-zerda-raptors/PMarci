package com.greenfoxacademy.services;

import com.greenfoxacademy.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by posam on 2017-01-04.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */

@Component
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllByOrderByScoreDesc(Pageable pageable);
}
