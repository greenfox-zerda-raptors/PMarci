package com.greenfoxacademy.controllers;

import com.greenfoxacademy.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.greenfoxacademy.services.PostServices.*;

/**
 * Created by posam on 2017-01-04.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */

@Controller
@RequestMapping("/posts")
public class PostsController {


    @RequestMapping(method = RequestMethod.GET)
    String listPosts(Model model) {
        listService(model);
        return "posts";
    }

    @GetMapping("/add")
    String add(Model model) {
        addService(model);
        return "add";
    }

    @PostMapping("/add")
    String postSubmit(@ModelAttribute @Valid Post post, BindingResult bindingResult) {
        return submitService(post, bindingResult);
    }


    @RequestMapping(value = "/{postID}/upvote", method = RequestMethod.GET)
    String upvote(Model model, @PathVariable("postID") Long postID) {
        upvoteService(postID);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/{postID}/downvote", method = RequestMethod.GET)
    String downvote(Model model, @PathVariable("postID") Long postID) {
        downvoteService(postID);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/deletthis")
    String delet() {
        deletService();
        return "redirect:/posts";
    }

//
//    @RequestMapping(value = " /posts/{postID}", method = RequestMethod.GET)
//    String showPost(Model model, @PathVariable("postID") Long postID) {
//    return null;
//    }

//    @RequestMapping("/1")
//    String firstPost(Model model) {
//        return "1";
//    }
}
