package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;


@Controller
public class BlogControllers {

    private static Logger log = Logger.getLogger(BlogControllers.class.getName());

    @GetMapping("/api")
    public String blog( Model model){
        model.addAttribute("title","Главная страница");
        log.info("Http api");
        return "blog";
    }
}
