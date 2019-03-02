package com.derteuffel.controller;

import com.derteuffel.data.Course;
import com.derteuffel.data.User;
import com.derteuffel.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by neword on 02/03/2019.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/addCourse")
    public String addCourse(Course course)
    {
        courseRepository.save(course);
        return "redirect:/user/users/courses/average";
    }

}
