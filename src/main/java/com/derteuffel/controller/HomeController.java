package com.derteuffel.controller;

import com.derteuffel.data.Post;
import com.derteuffel.repository.CompagnieRepository;
import com.derteuffel.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by derteuffel on 25/01/2019.
 */
@Controller
public class HomeController {
    @Autowired
    private CompagnieRepository compagnieRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("compagnies", compagnieRepository.findAll());

        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        System.out.println(posts);
        return "index";
    }

    @GetMapping("/")
    public String home1(Model model){
        model.addAttribute("compagnies", compagnieRepository.findAll());

        List<Post> posts = postRepository.findAll();
        List<String> dates = new ArrayList();

        model.addAttribute("posts",posts);
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("compagnies", compagnieRepository.findAll());
        return "about";
    }
}
