package com.greenfoxacademy.controllers;

import com.greenfoxacademy.models.Post;
import com.greenfoxacademy.services.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by posam on 2017-01-04.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */

@Controller
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    PostRepository postRepository;

    @RequestMapping(method = RequestMethod.GET)
    String listPosts(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "posts";
    }

    @GetMapping("/add")
    String add(Model model) {
        model.addAttribute("post", new Post());

        return "add";
    }

    @PostMapping("/add")
    String postSubmit(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/";
    }

    @RequestMapping(value = "/{postID}/upvote", method = RequestMethod.GET)
    String upvote(Model model, @PathVariable("postID") Long postID) {
        Post post = postRepository.findOne(postID).increment();
        postRepository.save(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/{postID}/downvote", method = RequestMethod.GET)
    String downvote(Model model, @PathVariable("postID") Long postID) {
        Post post = postRepository.findOne(postID).decrement();
        postRepository.save(post);
        return "redirect:/posts";
    }
//
//    @RequestMapping(value = " /posts/{postID}", method = RequestMethod.GET)
//    String showPost(Model model, int postID) {
//    return null;
//    }

//    @RequestMapping("/1")
//    String firstPost(Model model) {
//        return "1";
//    }
}
