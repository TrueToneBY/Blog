package com.example.demo.controllers;

import com.example.demo.models.Post;
import com.example.demo.repo.PostRepository;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class BlogController2 {
    private static Logger log = Logger.getLogger(BlogController2.class.getName());

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        log.info("http blog");
        return "blog-main";
    }

    /**
     * Добовление блога
     * @param model
     * @return
     */
    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        log.info("http blog/add");
        return "blog-add";
    }

    /**
     * Сохронение добавленных объектов
     * @param title
     * @param anons
     * @param full_text
     * @param model
     * @return переадресовываем ползователя на главную страницу блога
     */
    @PostMapping("/blog/blog/add")
    public String blogPostAdd(@RequestParam String title,
                              @RequestParam String anons,
                              @RequestParam String full_text, Model model){
        Post post = new Post(anons,title,full_text);
        postRepository.save(post);
        log.info("http redirect-blog");
        return "redirect:/blog";
    }

    /**
     * Найти блог по id
     * @param id индефикатор
     * @param model
     * @return
     */
    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model){
        //проверка на то если ввели несуществующий id
        if (!postRepository.existsById(id)){
            return "redirect:/blog";
        }

        //полученные записи помещаем в обьект который идет на основе класса optional
        Optional<Post> post = postRepository.findById(id);
        //Берем динамический лист и указываем что в нутри будут объекты в основе нашей модели Post
        ArrayList<Post> res = new ArrayList<>();
        //Оброщаемся к функции ifPresent для перевода из класса Optional в ArrayList
        post.ifPresent(res::add);
        //вывод из шаблона из базы данных на экран
        model.addAttribute("post",res);
        log.info("http blog-details");
        return "blog-details";
    }
}
