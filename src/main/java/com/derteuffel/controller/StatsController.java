package com.derteuffel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by neword on 28/02/2019.
 */

@Controller
@RequestMapping("/stats")
public class StatsController {

    @GetMapping("/all")
    public String users(){
        return "stats/stats";
    }
}
