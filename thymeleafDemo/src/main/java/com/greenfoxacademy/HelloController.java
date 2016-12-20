package com.greenfoxacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by posam on 2016-12-20.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/helloWorld")
    public String hello(Model model, @RequestParam(required = false, defaultValue = "Thymeleaf") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
}
