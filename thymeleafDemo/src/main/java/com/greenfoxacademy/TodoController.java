package com.greenfoxacademy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by posam on 2016-12-20.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
@Controller
@RequestMapping(value = "/todo")
public class TodoController {
    private ToDoService todoService;

    @RequestMapping(value = {"/", "/list"})
    public String list(Model model, @RequestParam String name) {
        return "list";
    }

    @Autowired
    public TodoController(ToDoService todoService) {
        this.todoService = todoService;
    }
}
