package com.greenfoxacademy.services;

import com.greenfoxacademy.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by posam on 2017-01-05.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */

@Component
public class PostServices {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    public PostServices(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void saveService(Post post) {
        postRepository.save(post);
    }

    public void upvoteService(Long postID) {
        Post post = postRepository.findOne(postID).increment();
        postRepository.save(post);
    }

    public void downvoteService(Long postID) {
        Post post = postRepository.findOne(postID).decrement();
        postRepository.save(post);
    }

    public void deletService() {
        postRepository.deleteAll();
    }

}
