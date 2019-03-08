package com.derteuffel.controller;

import com.derteuffel.data.Course;
import com.derteuffel.data.User;
import com.derteuffel.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neword on 02/03/2019.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/addCourse")
    public String addCourse(Course course, Errors errors, Model model)
    {
    Course course1=courseRepository.findByCourseName(course.getCourseName());
        if (course1 != null){
            errors.rejectValue("courseName","course.error","Il existe une Matiere deja avec ce titre");
        }
        if (errors.hasErrors()){
            model.addAttribute("errors","Vous ne pouvez pas enregistrer cette avec ce nom car il existe deja une matiere avec ce meme nom");
            return "compagnie/form";
        }else {
            courseRepository.save(course);
        }
        return "redirect:/user/users/courses/average";
    }

    @PostMapping("/update/{courseId}")
    public String update(Course course){
        courseRepository.save(course);
        return "redirect:/stats/all";
    }

    @DeleteMapping("/delete/{courseId}")
    public String delete(@PathVariable Long courseId){
        courseRepository.deleteById(courseId);
        return "redirect:/stats/all";
    }

}
