package com.derteuffel.controller;

import com.derteuffel.repository.CompagnieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by derteuffel on 25/01/2019.
 */
@Controller
public class HomeController {
    @Autowired
    private CompagnieRepository compagnieRepository;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("compagnies", compagnieRepository.findAll());
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("compagnies", compagnieRepository.findAll());
        return "about";
    }
}
