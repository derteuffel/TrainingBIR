package com.derteuffel.controller;

import com.derteuffel.data.*;
import com.derteuffel.repository.*;
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
import java.util.Iterator;
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
    private CourseRepository courseRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private SequenceRepository sequenceRepository;

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
        if (file != null){
            String fileName= fileUploadService.storeFile(file);
            user.setUserAvatar("/downloadFile/"+fileName);
        }else {
            user.setUserAvatar("/downloadFile/");
        }
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

        if (!file.isEmpty()){
            String fileName= fileUploadService.storeFile(file);
            user.setUserAvatar("/downloadFile/"+fileName);
        }else {
            user.setUserAvatar("/downloadFile/");
        }

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




    /**########## List of all the courses and their notes #########**/
    @GetMapping("/courses/{userId}")
    public String courses(Model model, @PathVariable Long userId) {
        List<Course> courses = courseRepository.findAll1();
        model.addAttribute("user", userRepository.findById(userId).get());
        model.addAttribute("courses", courses);
        model.addAttribute("sequences", sequenceRepository.findAll());
        List<List<Note>> notes = new ArrayList<List<Note>>();
        List<Note> temp = new ArrayList<>();
        List<Note> temp2 = new ArrayList<>();
        temp2.add(null);
        temp2.add(null);
        temp2.add(null);
        temp2.add(null);
        temp2.add(null);
        temp2.add(null);
        Iterator<Course> coursesIterator =  courses.iterator();
        while (coursesIterator.hasNext())
        {
            temp2= new ArrayList<>();
            temp2.add(null);
            temp2.add(null);
            temp2.add(null);
            temp2.add(null);
            temp2.add(null);
            temp2.add(null);
            temp = courseRepository.findNotesByCourseIdByUserId(coursesIterator.next().getCourseId(),userId);
            if(temp.size()==0)
            {
                temp.add(null);
                temp.add(null);
                temp.add(null);
                temp.add(null);
                temp.add(null);
                temp.add(null);
                notes.add(temp);
            }
            else {
                for (int i = 0; i < temp.size(); i++) {
                    temp2.set((int) (long) temp.get(i).getSequence().getSequenceNumber() - 1, temp.get(i));
                }
                notes.add(temp2);
            }
        }

        for(int i=0;i<notes.size();i++)
        {
                notes.get(i).add(new Note(average(notes.get(i)),null,null,null));

        }
        model.addAttribute("notes",notes);
        return "user/courses";
    }

    /**########## List of all the courses and their notes #########**/

    /** helper average **/
    public double average(List<Note> notes)
    {
        double average=0.0;
        for(int i=0;i<notes.size();i++)
        {

            if(notes.get(i)==null) ;
            else
            average+=notes.get(i).getNoteVal();
        }
        return average/notes.size();
    }
    /** helper average **/


    public double average2(List<Note> notes)
    {
        if(notes.size()==0) return 0;
        double average=0.0;
        for(int i=0;i<notes.size();i++)
        {
            average+=notes.get(i).getNoteVal();
        }
        return average/6;
    }
    /** helper average **/
    /**########## List of all the users, courses and averages #########**/
    @GetMapping("/users/courses/average")
    public String usersCoursesAverage(Model model) {
        List<Course> courses = courseRepository.findAll1();
        List<User> users = userRepository.findAllByStatus(true);
        model.addAttribute("courses", courses);
        model.addAttribute("users",users);
        List<List<Double>> averages = new ArrayList<>();
        List<Double> moyennes= new ArrayList<>();
        Double note=0.0;
        Double moyenne=0.0;
        for(int i=0;i< users.size();i++ )
        {
            List<Double> average1 = new ArrayList<>();
            for(int j=0;j< courses.size();j++ )
            {
                average1.add(average2(courseRepository.findNotesByCourseIdByUserId(courses.get(j).getCourseId(),users.get(i).getUserId())));
            }
                averages.add(average1);
            System.out.println(averages.get(i));
            for (Double note1 : average1){
                note=+note1;
            }
            moyenne=note/average1.size();
            moyennes.add(moyenne);
            System.out.println(average1);
        }
        System.out.println(moyennes);
        System.out.println(averages);
        model.addAttribute("moyennes",moyennes);
        model.addAttribute("course", new Course());
        model.addAttribute ("averages",averages);
        return "user/coursesAverage";
    }
    /**########## List of all the users, courses and averages #########**/


    /**########## Get one user #########**/

    @GetMapping("/detail/{userId}")
    public String detail(Model model, @PathVariable Long userId){
        User user =userRepository.getOne(userId);
        model.addAttribute("user",user);
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
