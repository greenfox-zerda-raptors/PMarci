package com.greenfoxacademy.controllers;

import com.greenfoxacademy.models.PageWrapper;
import com.greenfoxacademy.models.Post;
import com.greenfoxacademy.services.PostRepository;
import com.greenfoxacademy.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by posam on 2017-01-04.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */


@Controller
@RequestMapping("/posts")
public class PostsController {

    int current;

    @Autowired
    PostServices postServices;

    @Autowired
    PostRepository postRepository;

    @RequestMapping(method = RequestMethod.GET)
    String listPosts(Model model, @RequestParam(value = "page", defaultValue = "0") int pageNr, @PageableDefault(size = 5, page = 0) Pageable pageable) {
        PageWrapper<Post> page = new PageWrapper<Post>(postRepository.findAllByOrderByScoreDesc(pageable), "posts");
        model.addAttribute("page", page);

        this.current = page.getNumber();
        return "posts";
    }

    @GetMapping("/add")
    String add(Model model) {
        model.addAttribute("post", new Post());
        return "add";
    }

    @PostMapping("/add")
    String postSubmit(@ModelAttribute @Valid Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        } else {
            postServices.saveService(post);
            return "redirect:/";
        }
    }


    @RequestMapping(value = "/{postID}/upvote", method = RequestMethod.GET)
    String upvote(Model model, @PathVariable("postID") Long postID, final HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        postServices.upvoteService(postID);

        return "redirect:" + referrer;
    }

    @RequestMapping(value = "/{postID}/downvote", method = RequestMethod.GET)
    String downvote(Model model, @PathVariable("postID") Long postID, final HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        postServices.downvoteService(postID);
        return "redirect:" + referrer;
    }

    @RequestMapping(value = "/deletthis")
    String delet() {
        postServices.deletService();
        return "redirect:/posts";
    }


    @RequestMapping(value = " /posts/{postID}", method = RequestMethod.GET)
    String showPost(Model model, @PathVariable("postID") Long postID) {
        return null;
    }

    @RequestMapping("/1")
    String firstPost(Model model) {
        return "1";
    }
}
