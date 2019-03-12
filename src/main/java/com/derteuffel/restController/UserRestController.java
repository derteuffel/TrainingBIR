package com.derteuffel.restController;

import com.derteuffel.data.User;
import com.derteuffel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by derteuffel on 14/02/2019.
 */
@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public List<User> user(){
        long a=1;
        List<User> users= userRepository.findAllByStatus(a);
        return users;
    }



}
