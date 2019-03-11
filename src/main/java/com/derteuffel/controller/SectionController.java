package com.derteuffel.controller;

import com.derteuffel.data.Section;
import com.derteuffel.data.User;
import com.derteuffel.repository.CompagnieRepository;
import com.derteuffel.repository.SectionRepository;
import com.derteuffel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by derteuffel on 04/03/2019.
 */
@Controller
@RequestMapping("/section")
public class SectionController {

    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private CompagnieRepository compagnieRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/add/form")
    public String add(Model model){
        model.addAttribute("section", new Section());
        return "section/form";
    }

    @GetMapping("/edit/form/{sectionId}")
    public String edit(Model model, @PathVariable Long sectionId){
        model.addAttribute("section", sectionRepository.getOne(sectionId));
        return "section/edit";
    }

    @PostMapping("/update/{sectionId}")
    public String upadte(Section section,HttpSession session, @RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            sectionRepository.save(section);
        }else {
            String fileName= fileUploadService.storeFile(file);
            section.setCompagnie(compagnieRepository.getOne((Long)session.getAttribute("compagnieId")));
            section.setSectionAvatar("/downloadFile/"+fileName);
            sectionRepository.save(section);
        }
        return "redirect:/compagnie/detail/"+(Long)session.getAttribute("compagnieId");
    }

    @PostMapping("/save")
    public String save(Section section, Errors errors, Model model, HttpSession session, @RequestParam("file") MultipartFile file){

        Section section1= sectionRepository.findBySectionName(section.getSectionName());
        if (section1 != null){
            errors.rejectValue("sectionName","section.error","Il existe une section avec ce nom");
        }
        if (errors.hasErrors()) {
           model.addAttribute("errors","Vous ne pouvez pas enregistrer deux ffois ce meme élement");
            return "section/form";
        }else {
            String fileName= fileUploadService.storeFile(file);
            section.setSectionAvatar(fileName);
            section.setCompagnie(compagnieRepository.getOne((Long)session.getAttribute("compagnieId")));
            Section section2 = sectionRepository.save(section);
            return "redirect:/section/detail/" +section2.getSectionId();
        }
    }

    @GetMapping("/detail/{sectionId}")
    public String detail(Model model, @PathVariable Long sectionId){
        model.addAttribute("section",sectionRepository.getOne(sectionId));
        long a = 1;
        List<User> allByStatus=userRepository.findAllByStatus(a);
        List<User> allBySection=userRepository.findBySection(sectionId);
        List<User>users=new ArrayList<>();
        for (User user: allBySection){
            for (int i=0; i<allBySection.size();i++){
                if (user.getStatus() == a){
                    users.add(user);
                }
            }
        }
        System.out.println(users);
        model.addAttribute("users",users);
        return "section/detail";
    }

}
