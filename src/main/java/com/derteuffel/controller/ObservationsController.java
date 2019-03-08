package com.derteuffel.controller;

import com.derteuffel.data.Observations;
import com.derteuffel.repository.ObservationsRepository;
import com.derteuffel.repository.UserRepository;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by derteuffel on 07/03/2019.
 */
@Controller
@RequestMapping("/observations")
public class ObservationsController {
    @Autowired
    private ObservationsRepository observationsRepository;
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/all")
    public String all(Model model) {

        model.addAttribute("observationses", observationsRepository.findAll());
        return "observations/observationses";
    }

    @GetMapping("/user/{userId}")
    public String byUsers(Model model, @PathVariable Long userId) {
        List<Observations> observationses = observationsRepository.findAllByUser(userId);
        model.addAttribute("observationses", observationses);
        model.addAttribute("observations", new Observations());
        return "user/observations/observations";
    }

    public FileUploadRespone uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileUploadService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new FileUploadRespone(fileName, fileDownloadUri);
    }

    @PostMapping("/save")
    public String save(Observations observations, @RequestParam("files") MultipartFile files, HttpSession session) {

        List<FileUploadRespone> pieces = Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
        if (pieces.size() == 0) {
            observations.setObservationsFiles(observations.getObservationsFiles());
        } else {
            ArrayList<String> filesPaths = new ArrayList<String>();
            for (int i = 0; i < pieces.size(); i++) {

                filesPaths.add(pieces.get(i).getFileDownloadUri());

            }

            observations.setObservationsFiles(filesPaths);
        }

        observations.setUser(userRepository.getOne((Long) session.getAttribute("userId")));

        observationsRepository.save(observations);

        return "redirect:/observations/user/" + (Long) session.getAttribute("userId");

    }

    @DeleteMapping("/delete/{observationId}")
    public String delete(@PathVariable Long observationId, HttpSession session){
observationsRepository.deleteById(observationId);
        return "redirect:/observations/user/"+(Long)session.getAttribute("userId");
    }


}
