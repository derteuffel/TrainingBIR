package com.derteuffel.controller;

import com.derteuffel.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by neword on 28/02/2019.
 */

@Controller
@RequestMapping("/stats")
public class StatsController {
    @Autowired

    CourseRepository courseRepository;
    @GetMapping("/all")
    public String users(Model model){

        model.addAttribute("courses", courseRepository.findAll());
        return "stats/stats";
    }
}
