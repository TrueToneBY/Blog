package com.example.demo.controllers;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;


@Controller
public class BlogControllers {

    private static Logger log = Logger.getLogger(BlogControllers.class.getName());

    /**
     * контрольный api вход в http
     * @param model примитивно записано главная страница
     * @return возрощает страницу blog html разметкой
     */
    @GetMapping("/api")
    public String blog( Model model){
        model.addAttribute("title","Главная страница");
        log.info("Http api");
        return "blog";
    }

    /**
     * контрольный api вход в http /about
     * @param model возрощает Страниц про нас
     * @return возрощает содиржимое Страницы про нас
     */
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title","Страница про нас");
        log.info("http about");
        return "about";
    }

    /**
     * контрольный api вход в http /Pricing
     * @param model возрощает Цены
     * @return возрощает содиржимое цен
     */
    @GetMapping("/Pricing")
    public String pricing(Model model){
        model.addAttribute("title","Цены");
        log.info("http pricing");
        return "pricing";
    }

}
