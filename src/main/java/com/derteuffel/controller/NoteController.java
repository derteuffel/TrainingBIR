package com.derteuffel.controller;

import com.derteuffel.data.Course;
import com.derteuffel.data.Note;
import com.derteuffel.data.Sequence;
import com.derteuffel.data.User;
import com.derteuffel.repository.CourseRepository;
import com.derteuffel.repository.NoteRepository;
import com.derteuffel.repository.SequenceRepository;
import com.derteuffel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neword on 01/03/2019.
 */

@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SequenceRepository sequenceRepository;
    @Autowired
    private NoteRepository noteRepository;

    /**########## Adding a note #########**/
    @GetMapping("/addnote/{userId}/{courseId}/{sequenceId}")
    public String addNote(Model model, @PathVariable Long userId, @PathVariable Long courseId, @PathVariable Long sequenceId, @RequestParam("noteVal") double noteVal) {
        System.out.println(userId);
        User user = userRepository.findById(userId).get();
        System.out.println(courseId);

        Course course = courseRepository.findById(courseId).get();
        Sequence sequence = sequenceRepository.findById(sequenceId).get();
        Note note = new Note(noteVal,user,course,sequence);
        noteRepository.save(note);

        return "redirect:/user/courses/" + userId;
    }
    /**########## Adding a note #########**/
}
