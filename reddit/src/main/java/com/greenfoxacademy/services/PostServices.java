package com.greenfoxacademy.services;

import com.greenfoxacademy.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 * Created by posam on 2017-01-05.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */

@Component
public class PostServices {

    private static PostRepository postRepository;

    @Autowired
    public PostServices(PostRepository postRepository) {
        PostServices.postRepository = postRepository;
    }

    public static void listService(Model model) {
        model.addAttribute("posts", postRepository.findAll());
    }

    public static void addService(Model model) {
        model.addAttribute("post", new Post());
    }

    public static String submitService(Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        } else {
            postRepository.save(post);
            return "redirect:/";
        }
    }

    public static void upvoteService(Long postID) {
        Post post = postRepository.findOne(postID).increment();
        postRepository.save(post);
    }

    public static void downvoteService(Long postID) {
        Post post = postRepository.findOne(postID).decrement();
        postRepository.save(post);
    }

    public static void deletService() {
        postRepository.deleteAll();
    }

}
