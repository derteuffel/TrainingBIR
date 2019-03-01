package com.derteuffel.controller;

import com.derteuffel.data.Course;
import com.derteuffel.data.Note;
import com.derteuffel.repository.CourseRepository;
import com.derteuffel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neword on 28/02/2019.
 */

@Controller
@RequestMapping("/stats")
public class StatsController {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserRepository userRepository;
    /** helper average **/
    public double average(List<Note> notes, long divider)
    {
        if(notes.size()==0) return 0;
       double average=0.0;
        for(int i=0;i<notes.size();i++)
        {
                average+=notes.get(i).getNoteVal();
        }
        return average/divider;
    }

    @GetMapping("/all")
    public String users(Model model){

        List<Double> averages = new ArrayList<>();
        List<Course> course = courseRepository.findAll1();
        long divider = userRepository.findAll().size();
        for(int i=0;i<course.size();i++)
        {
            averages.add(average(courseRepository.findNotesByCourseId(course.get(i).getCourseId()),divider));
        }


        model.addAttribute("averages",averages);
        model.addAttribute("courses", courseRepository.findAll1());
        return "stats/stats";
    }
}
