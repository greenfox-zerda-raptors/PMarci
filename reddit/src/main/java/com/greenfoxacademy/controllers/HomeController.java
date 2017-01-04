package com.greenfoxacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by posam on 2017-01-04.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    String index(Model model) {
        model.addAttribute("message", "Welcome to Die");
        return "redirect:/posts";
    }
}
