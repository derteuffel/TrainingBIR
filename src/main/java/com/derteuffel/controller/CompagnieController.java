package com.derteuffel.controller;

import com.derteuffel.data.Compagnie;
import com.derteuffel.data.Section;
import com.derteuffel.data.User;
import com.derteuffel.repository.CompagnieRepository;
import com.derteuffel.repository.SectionRepository;
import com.derteuffel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
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

    @GetMapping("/jouer/foot/{compagnieId}")
    public String foots(@PathVariable Long compagnieId, Model model){
        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        model.addAttribute("compagnie", compagnie);
        List<User> users= new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }

        List<User> foots= new ArrayList<>();
        for (User user : users){
            for(String sport : user.getSports())
            {
                if (sport.contains("FOOT")) {
                    foots.add(user);
                }
            }

        }

        model.addAttribute("users", foots);
        return"compagnie/statistique";
    }
    @GetMapping("/jouer/hand/{compagnieId}")
    public String hands(@PathVariable Long compagnieId, Model model){
        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        model.addAttribute("compagnie", compagnie);
        List<User> users= new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }

        List<User> foots= new ArrayList<>();
        for (User user : users){
            for(String sport : user.getSports())
            {
                if (sport.contains("HAND")) {
                    foots.add(user);
                }
            }

        }

        model.addAttribute("users", foots);
        return"compagnie/statistique";
    }
    @GetMapping("/jouer/basket/{compagnieId}")
    public String baskets(@PathVariable Long compagnieId, Model model){
        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        model.addAttribute("compagnie", compagnie);
        List<User> users= new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }

        List<User> foots= new ArrayList<>();
        for (User user : users){
            for(String sport : user.getSports())
            {
                if (sport.contains("BASKET")) {
                    foots.add(user);
                }
            }

        }

        model.addAttribute("users", foots);
        return"compagnie/statistique";
    }
    @GetMapping("/jouer/volley/{compagnieId}")
    public String volleys(@PathVariable Long compagnieId, Model model){
        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        model.addAttribute("compagnie", compagnie);
        List<User> users= new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }

        List<User> foots= new ArrayList<>();
        for (User user : users){
            for(String sport : user.getSports())
            {
                if (sport.contains("VOL")) {
                    foots.add(user);
                }
            }

        }

        model.addAttribute("users", foots);
        return"compagnie/statistique";
    }
    @GetMapping("/jouer/karate/{compagnieId}")
    public String karates(@PathVariable Long compagnieId, Model model){
        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        model.addAttribute("compagnie", compagnie);
        List<User> users= new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }

        List<User> foots= new ArrayList<>();
        for (User user : users){
            for(String sport : user.getSports())
            {
                if (sport.contains("KARAT")) {
                    foots.add(user);
                }
            }

        }

        model.addAttribute("users", foots);
        return"compagnie/statistique";
    }
    @GetMapping("/jouer/tennis/{compagnieId}")
    public String tennis(@PathVariable Long compagnieId, Model model){
        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        model.addAttribute("compagnie", compagnie);
        List<User> users= new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }

        List<User> foots= new ArrayList<>();
        for (User user : users){
            for(String sport : user.getSports())
            {
                if (sport.contains("TEN")) {
                    foots.add(user);
                }
            }

        }

        model.addAttribute("users", foots);
        return"compagnie/statistique";
    }
    @GetMapping("/jouer/kung_fu/{compagnieId}")
    public String kung_fu(@PathVariable Long compagnieId, Model model){
        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        model.addAttribute("compagnie", compagnie);
        List<User> users= new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }

        List<User> foots= new ArrayList<>();
        for (User user : users){
            for(String sport : user.getSports())
            {
                if (sport.contains("KUNG")) {
                    foots.add(user);
                }
            }

        }

        model.addAttribute("users", foots);
        return"compagnie/statistique";
    }
    @GetMapping("/ecrire/francais/{compagnieId}")
    public String ecrireFrancais(@PathVariable Long compagnieId, Model model){
        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        model.addAttribute("compagnie", compagnie);
        List<User> users= new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }

        List<User> ecrireFrancais= new ArrayList<>();
        for (User user : users){
            for(String language : user.getWhritingLanguages())
            {
                if (language.contains("FRANCAIS")) {
                    ecrireFrancais.add(user);
                }
            }

        }

        model.addAttribute("users", ecrireFrancais);
        return"compagnie/statistique";
    }
    @GetMapping("/ecrire/anglais/{compagnieId}")
    public String anglais(@PathVariable Long compagnieId, Model model){
        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        model.addAttribute("compagnie", compagnie);
        List<User> users= new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }

        List<User> ecrireAnglais= new ArrayList<>();
        for (User user : users){
            for(String language : user.getWhritingLanguages())
            {
                if (language.contains("ENGL")|language.contains("ANGL")) {
                    ecrireAnglais.add(user);
                }
            }

        }

        model.addAttribute("users", ecrireAnglais);
        return"compagnie/statistique";
    }
    @GetMapping("/parler/francais/anglais/{compagnieId}")
    public String francaisEtAnglais(@PathVariable Long compagnieId, Model model){
        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        model.addAttribute("compagnie", compagnie);
        List<User> users= new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }

        List<User> parlerFrancaisEtAnglais= new ArrayList<>();
        for (User user : users){
            for(String language : user.getTalkingLanguages())
            {
                if (language.contains("FRANCAIS")&language.contains("ANGL")) {
                    parlerFrancaisEtAnglais.add(user);
                }
            }

        }

        model.addAttribute("users", parlerFrancaisEtAnglais);
        return"compagnie/statistique";
    }
    @GetMapping("/parler/anglais/{compagnieId}")
    public String parlerFrancais(@PathVariable Long compagnieId, Model model){
        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        model.addAttribute("compagnie", compagnie);
        List<User> users= new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }

        List<User> parlerAnglais= new ArrayList<>();
        for (User user : users){
            for(String language : user.getTalkingLanguages())
            {
                if (language.contains("ENGL")|language.contains("ANGL")) {
                    parlerAnglais.add(user);
                }
            }

        }


        model.addAttribute("users", parlerAnglais);
        return"compagnie/statistique";
    }

    @GetMapping("/ecrire/francais/anglais/{compagnieId}")
    public String statiques(@PathVariable Long compagnieId, Model model){
        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        model.addAttribute("compagnie", compagnie);
        List<User> users= new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }

        List<User> ecrireFrancaisEtAnglais= new ArrayList<>();

        for (User user : users){
            for(String language : user.getWhritingLanguages())
            {
                if (language.contains("FRANCAIS")& language.contains("ANGL")) {
                    ecrireFrancaisEtAnglais.add(user);
                }
            }

        }

        for (User user : users){
            for(String sport : user.getSports())
            {
                if (sport.contains("FOOT")) {
                    ecrireFrancaisEtAnglais.add(user);
                }
            }

        }

        model.addAttribute("users", ecrireFrancaisEtAnglais);
        return "compagnie/statistique";
    }

    public List<User> sort(List<User> m_users, Compagnie compagnie, List<Section> sections )
    {
        List<User> users=new ArrayList<>();
        List<User> users2=new ArrayList<>();
        for (Section section : sections){
            users.addAll(userRepository.findBySection(section.getSectionId()));
        }

        List<User> users1=m_users;
        for (User user : users1){
            for (int i=0;i<users.size();i++){
                if (user.getUserId().equals(users.get(i).getUserId())){
                    users2.add(user);
                }
            }
        }
        return users2;
    }

    @GetMapping("/region/{compagnieId}/{userRegion}")
    public String stats(@PathVariable String userRegion, @PathVariable Long compagnieId, Model model){

        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        List<User> users1=userRepository.findAllByUserRegion(userRegion);
        model.addAttribute("users",sort(users1,compagnie,sections));
        model.addAttribute("compagnie", compagnie);
        return "compagnie/statistique";
    }

    @GetMapping("/departement/{compagnieId}/{userDivision}")
    public String stats1(@PathVariable String userDivision, @PathVariable Long compagnieId, Model model){

        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        List<User> users1=userRepository.findAllByUserDivision(userDivision);
        model.addAttribute("users",sort(users1,compagnie,sections));
        model.addAttribute("compagnie", compagnie);
        return "compagnie/statistique";
    }
    @GetMapping("/diplome/{compagnieId}/{userHigerCivilDiplom}")
    public String stats2(@PathVariable String userHigerCivilDiplom, @PathVariable Long compagnieId, Model model){

        Compagnie compagnie= compagnieRepository.getOne(compagnieId);
        List<Section> sections=sectionRepository.findAllByCompagnie(compagnie.getCompagnieId());
        List<User> users=new ArrayList<>();
        for (Section section : sections){

            users.addAll(userRepository.findBySection(section.getSectionId()));
        }
        List<User> usersDiplomes= new ArrayList<>();
        for (User user : users){

            if(userHigerCivilDiplom.toUpperCase().contains(user.getUserHigerCivilDiplom().toUpperCase()))
            {

                usersDiplomes.add(user);
            }
        }
        model.addAttribute("users",usersDiplomes);
        model.addAttribute("compagnie", compagnie);
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
