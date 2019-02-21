package com.derteuffel.controller;

import com.derteuffel.data.PagerModel;
import com.derteuffel.data.User;
import com.derteuffel.repository.CompagnieRepository;
import com.derteuffel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by derteuffel on 25/01/2019.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = {5,10,15,20,25,30,35,40};
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private CompagnieRepository compagnieRepository;

    /**########## Retrieves all users #########**/
  /*  @GetMapping("/all")
    public String users(Model model, @PageableDefault(size = 6) Pageable pageable, @RequestParam("pageSize") Optional<Integer> pageSize,
                        @RequestParam("page") Optional<Integer> page){

        Page<User> users= userRepository.findAll(pageable);
        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        // print repo
        // evaluate page size
        model.addAttribute("selectedPageSize", evalPageSize);
        // add pages size
        model.addAttribute("pageSizes", PAGE_SIZES);
        Page<User> list4= userRepository.findAll( new PageRequest(evalPage, evalPageSize));
        PagerModel pager = new PagerModel(list4.getTotalPages(),list4.getNumber(),BUTTONS_TO_SHOW);
        model.addAttribute("pager", pager);
        model.addAttribute("users",users);
        model.addAttribute("compagnies", compagnieRepository.findAll());
        return "user/users";
    }*/

    @GetMapping("/all")
    public String users(){
        return "user/users";
    }



    /**########## Form for an user #########**/
    @GetMapping("/add/form")
    public String form(Model model){
        model.addAttribute("user", new User());
        return "user/form";
    }



    /**########## Update an user #########**/
    @PostMapping("/update/identification")
    public String updateIdentification(User user, Model model, @RequestParam("file") MultipartFile file){

        String fileName= fileUploadService.storeFile(file);
        user.setUserAvatar("/downloadFile/"+fileName);
        user.setStatus(true);
        userRepository.save(user);

        return "redirect:/user/detail/"+user.getUserId();
    }

    /**########## Update an user #########**/
    @PostMapping("/update")
    public String updateSignalement(User user){
        user.setStatus(true);
        userRepository.save(user);

        return "redirect:/user/detail/"+user.getUserId();
    }

    /**########## Update an user #########**/
    @PostMapping("/update/instruction")
    public String updateInstruction(User user){


        String[] talkingLanguages= user.getTalkingLanguage().split(";");
        ArrayList<String> talkings= new ArrayList<>();
        for (int i=0;i<talkingLanguages.length;i++){
            talkings.add(talkingLanguages[i]);
            user.setTalkingLanguages(talkings);
        }
        user.setTalkingLanguage(null);
        String[] writingLanguages= user.getWhritingLanguage().split(";");
        ArrayList<String> writing= new ArrayList<>();
        for (int h=0;h<writingLanguages.length;h++){
            writing.add(writingLanguages[h]);
            user.setWhritingLanguages(writing);
        }
        user.setWhritingLanguage(null);
        userRepository.save(user);

        return "redirect:/user/detail/"+user.getUserId();
    }

    /**########## Update an user #########**/
    @PostMapping("/update/professionnel")
    public String updateprofessionnel(User user){

        String[] specialites= user.getSpecialitie().split(";");
        ArrayList<String> specialite= new ArrayList<>();
        for (int g=0;g<specialites.length;g++){
            specialite.add(specialites[g]);
            user.setSpecialities(specialite);
        }
        user.setSpecialitie(null);
        user.setStatus(true);
        userRepository.save(user);

        return "redirect:/user/detail/"+user.getUserId();
    }

    /**########## Update an user #########**/
    @PostMapping("/update/complementaire")
    public String updateComplementaire(User user){

        String[] decorations= user.getDecorationsAndDate().split(";");
        ArrayList<String> decoration= new ArrayList<>();
        for (int a=0;a<decorations.length;a++){
            decoration.add(decorations[a]);
            user.setDecorationsAndDates(decoration);
        }
        user.setDecorationsAndDate(null);


        String[] stages= user.getInternshipAndCourse().split(";");
        ArrayList<String> stage= new ArrayList<>();
        for (int b=0;b<stages.length;b++){
            stage.add(stages[b]);
            user.setInternshipAndCourses(stage);
        }

        user.setInternshipAndCourse(null);

        String[] medicalBackups= user.getMedicalBackup().split(";");
        ArrayList<String> medicalBackup= new ArrayList<>();
        for (int c=0;c<medicalBackups.length;c++){
            medicalBackup.add(medicalBackups[c]);
            user.setMedicalBackups(medicalBackup);
        }

        user.setMedicalBackup(null);

        String[] lastKnowledges= user.getLastKnowledge().split(";");
        ArrayList<String> lastKnowledge= new ArrayList<>();
        for (int d=0;d<lastKnowledges.length;d++){
            lastKnowledge.add(lastKnowledges[d]);
            user.setLastKnowledges(lastKnowledge);
        }
        user.setLastKnowledge(null);

        String[] sports= user.getSport().split(";");
        ArrayList<String> sport= new ArrayList<>();
        for (int e=0;e<sports.length;e++){
            sport.add(sports[e]);
            user.setSports(sport);
        }
        user.setSport(null);

        String[] marques= user.getParticularMark().split(";");
        ArrayList<String> marque= new ArrayList<>();
        for (int f=0;f<marques.length;f++){
            marque.add(marques[f]);
            user.setParticularMarks(marque);
        }

        user.setParticularMark(null);

        user.setStatus(true);
        userRepository.save(user);

        return "redirect:/user/detail/"+user.getUserId();
    }

    /**########## Save an user #########**/
    @PostMapping("/save")
    public String save(User user, Model model, Errors errors, @RequestParam("file") MultipartFile file){

        String fileName= fileUploadService.storeFile(file);
        user.setUserAvatar("/downloadFile/"+fileName);
        User user1= userRepository.findByUserMilitaryCodeIgnoreCase(user.getUserMilitaryCode());
        if (user1 != null){
            errors.rejectValue("userMilitaryCode","user.error","Il existe déja un utilisateur avec ce code");
        }
        if (errors.hasErrors()){
            model.addAttribute("errors"," Il existe déja un utilisateur avec le  meme code");
            return "user/form";
        }else {

            String[] talkingLanguages= user.getTalkingLanguage().split(";");
            ArrayList<String> talkings= new ArrayList<>();
            for (int i=0;i<talkingLanguages.length;i++){
                talkings.add(talkingLanguages[i]);
                user.setTalkingLanguages(talkings);
            }
            user.setTalkingLanguage(null);
            String[] writingLanguages= user.getWhritingLanguage().split(";");
            ArrayList<String> writing= new ArrayList<>();
            for (int h=0;h<writingLanguages.length;h++){
                writing.add(writingLanguages[h]);
                user.setWhritingLanguages(writing);
            }
            user.setWhritingLanguage(null);

            String[] specialites= user.getSpecialitie().split(";");
            ArrayList<String> specialite= new ArrayList<>();
            for (int g=0;g<specialites.length;g++){
                specialite.add(specialites[g]);
                user.setSpecialities(specialite);
            }
            user.setSpecialitie(null);

            String[] decorations= user.getDecorationsAndDate().split(";");
            ArrayList<String> decoration= new ArrayList<>();
            for (int a=0;a<decorations.length;a++){
                decoration.add(decorations[a]);
                user.setDecorationsAndDates(decoration);
            }
            user.setDecorationsAndDate(null);


            String[] stages= user.getInternshipAndCourse().split(";");
            ArrayList<String> stage= new ArrayList<>();
            for (int b=0;b<stages.length;b++){
                stage.add(stages[b]);
                user.setInternshipAndCourses(stage);
            }

            user.setInternshipAndCourse(null);

            String[] medicalBackups= user.getMedicalBackup().split(";");
            ArrayList<String> medicalBackup= new ArrayList<>();
            for (int c=0;c<medicalBackups.length;c++){
                medicalBackup.add(medicalBackups[c]);
                user.setMedicalBackups(medicalBackup);
            }

            user.setMedicalBackup(null);

            String[] lastKnowledges= user.getLastKnowledge().split(";");
            ArrayList<String> lastKnowledge= new ArrayList<>();
            for (int d=0;d<lastKnowledges.length;d++){
                lastKnowledge.add(lastKnowledges[d]);
                user.setLastKnowledges(lastKnowledge);
            }
            user.setLastKnowledge(null);

            String[] sports= user.getSport().split(";");
            ArrayList<String> sport= new ArrayList<>();
            for (int e=0;e<sports.length;e++){
                sport.add(sports[e]);
                user.setSports(sport);
            }
            user.setSport(null);

            String[] marques= user.getParticularMark().split(";");
            ArrayList<String> marque= new ArrayList<>();
            for (int f=0;f<marques.length;f++){
                marque.add(marques[f]);
                user.setParticularMarks(marque);
            }

            user.setParticularMark(null);
            user.setStatus(true);

            userRepository.save(user);
        }

        return "redirect:/user/all";
    }

    /**########## Get one user #########**/

    @GetMapping("/detail/{userId}")
    public String detail(Model model, @PathVariable Long userId){

        Optional<User> optional = userRepository.findById(userId);

        model.addAttribute("user",optional.get());
        return "user/detail";
    }

    /**########## Delete one user #########**/
    @GetMapping("/delete/{userId}")
    public String delete(@PathVariable Long userId){
        User user= userRepository.getOne(userId);
        user.setStatus(false);
        userRepository.save(user);
        return "redirect:/user/all";
    }

    /**########## Update Indentification of one user #########**/
    @GetMapping("/update/identification/{userId}")
    public String identification(Model model, @PathVariable Long userId){
        model.addAttribute("user", userRepository.findById(userId).get());
        return "user/update/identification";
    }

    /**########## Update Familial of one user #########**/
    @GetMapping("/update/familial/{userId}")
    public String familial(Model model, @PathVariable Long userId){
        model.addAttribute("user", userRepository.findById(userId).get());
        return "user/update/familial";
    }

    /**########## Update Instruction of one user #########**/
    @GetMapping("/update/instruction/{userId}")
    public String instruction(Model model, @PathVariable Long userId){
        model.addAttribute("user", userRepository.findById(userId).get());
        return "user/update/instruction";
    }

    /**########## Update Professionnel of one user #########**/
    @GetMapping("/update/professionnel/{userId}")
    public String professionnel(Model model, @PathVariable Long userId){
        model.addAttribute("user", userRepository.findById(userId).get());
        return "user/update/professionnel";
    }

    /**########## Update Complementaire of one user #########**/
    @GetMapping("/update/complementaire/{userId}")
    public String complementaire(Model model, @PathVariable Long userId){
        model.addAttribute("user", userRepository.findById(userId).get());
        return "user/update/complementaire";
    }

    /**########## Update Signalement of one user #########**/
    @GetMapping("/update/signalement/{userId}")
    public String signalement(Model model, @PathVariable Long userId){
        model.addAttribute("user", userRepository.findById(userId).get());
        return "user/update/signalement";
    }



}
