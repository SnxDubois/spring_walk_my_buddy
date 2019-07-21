package com.checkpoint4.walkmybuddy.controller;

import com.checkpoint4.walkmybuddy.entity.DogWalker;
import com.checkpoint4.walkmybuddy.repository.DogWalkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogWalkerController {

    @Autowired
    private DogWalkerRepository dogWalkerRepository;

    @PostMapping("/dogWalkers/signUp")
    public DogWalker signUpDogWalker(@RequestBody DogWalker dogWalker) {
        return dogWalkerRepository.save(dogWalker);
    }

    @PostMapping("/dogWalkers/signIn")
    public DogWalker singInDogWalker(@RequestBody DogWalker dogWalker) {
        return dogWalkerRepository.findByEmailAndPassword(dogWalker.getEmail(), dogWalker.getPassword());
    }
}
