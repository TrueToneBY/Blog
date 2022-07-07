package com.example.demo.controllers;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class BlogController2 {
    private static Logger log = Logger.getLogger(BlogController2.class.getName());
    @GetMapping("/blog")
    public String blogMain(Model model){
        model.addAttribute("title","Блог");
        log.info("http blog");
        return "blog-main";
    }
}
