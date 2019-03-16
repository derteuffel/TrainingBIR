package com.derteuffel.controller;

import com.derteuffel.data.Compagnie;
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
import java.util.Collection;
import java.util.List;

/**
 * Created by derteuffel on 12/02/2019.
 */
@Controller
@RequestMapping("/compagnie")
public class CompagnieController {
    @Autowired
    private CompagnieRepository compagnieRepository;
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SectionRepository sectionRepository;

    @GetMapping("/all")
    public String compagnies(Model model){
        Collection<Compagnie> compagnies= compagnieRepository.findAll();
        model.addAttribute("compagnies", compagnies);
        return "compagnie/compagnies";
    }
    @GetMapping("/detail/{compagnieId}")
    public String compagnie(@PathVariable Long compagnieId, Model model, HttpSession session){
        session.setAttribute("compagnieId", compagnieId);
        List<Section> sections= sectionRepository.findAllByCompagnie(compagnieId);
        model.addAttribute("sections", sections);
        model.addAttribute("compagnie", compagnieRepository.getOne(compagnieId));

        return "compagnie/detail";
    }

    @GetMapping("/statistique/{compagnieId}")
    public String statiques(@PathVariable Long compagnieId, Model model){
        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        model.addAttribute("compagnie", compagnie);
        List<User> users= new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }
        System.out.println(users.size());
        List<String> languages= new ArrayList<>();
        List<User> parlerFrancais= new ArrayList<>();
        List<User> parlerAnglais= new ArrayList<>();
        List<User> ecrireAnglais= new ArrayList<>();
        List<User> ecrireFrancais= new ArrayList<>();
        for (User user : users){
            for(String language : user.getTalkingLanguages())
            {
                if (language.contains("FRANCAIS")) {
                    parlerFrancais.add(user);
                }
            }

        }
        for (User user : users){
            for(String language : user.getTalkingLanguages())
            {
                if (language.contains("ENGL")|language.contains("ANGL")) {
                    parlerAnglais.add(user);
                }
            }

        }

        for (User user : users){
            for(String language : user.getWhritingLanguages())
            {
                if (language.contains("ENGL")|language.contains("ANGL")) {
                    ecrireAnglais.add(user);
                }
            }

        }
        for (User user : users){
            for(String language : user.getWhritingLanguages())
            {
                if (language.contains("FRANCAIS")) {
                    ecrireFrancais.add(user);
                }
            }

        }
        System.out.println(parlerFrancais);

        return "compagnie/statistique";
    }

    @GetMapping("/add/form")
    public String form(Model model){
        model.addAttribute("compagnie", new Compagnie());
        return "compagnie/form";
    }

    @GetMapping("/edit/form/{compagnieId}")
    public String edit(Model model, @PathVariable Long compagnieId){
        Compagnie compagnie=compagnieRepository.getOne(compagnieId);
        model.addAttribute("compagnie", compagnie);
        return "compagnie/edit";
    }

    @PostMapping("/update/{compagnieId}")
    public String update(Compagnie compagnie,@RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            compagnieRepository.save(compagnie);
        }else {
            String fileName= fileUploadService.storeFile(file);
            compagnie.setCompagnieAvatar("/downloadFile/"+fileName);
            compagnieRepository.save(compagnie);
        }
        return "redirect:/compagnie/all";
    }

    @PostMapping("/save")
    public String save(Compagnie compagnie, Errors errors, Model model, @RequestParam("file") MultipartFile file){

        Compagnie compagnie1= compagnieRepository.findByCompagnieName(compagnie.getCompagnieName());
        if (compagnie1 != null){
            errors.rejectValue("compagnieName","compagnie.error","Il existe une Compagnie avec ce nom");
        }
        if (errors.hasErrors()){
            model.addAttribute("errors","Il existe une Compagnie avec ce nom dans la base de donnée");
            return "compagnie/form";
        }else {

            String fileName= fileUploadService.storeFile(file);
            compagnie.setCompagnieAvatar("/downloadFile/"+fileName);
            compagnieRepository.save(compagnie);
        }

        return "redirect:/compagnie/all";

    }

    @GetMapping("/update/{compagnieId}")
    public String update(@PathVariable Long compagnieId, Model model){

        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        model.addAttribute("compagnie", compagnie);
        return "compagnie/update";
    }

}
