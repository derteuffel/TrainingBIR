package com.derteuffel.controller;

import com.derteuffel.data.Course;
import com.derteuffel.data.Note;
import com.derteuffel.data.Post;
import com.derteuffel.data.User;
import com.derteuffel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by derteuffel on 25/01/2019.
 */
@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @PostMapping("/save")
    public String save(HttpServletRequest request)
    {
        Post post = new Post( request.getParameter("postDescription"),request.getParameter("postTitle"), new Date());
        postRepository.save(post);
        return "redirect:/";
    }







}
