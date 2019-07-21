package com.checkpoint4.walkmybuddy.controller;

import com.checkpoint4.walkmybuddy.entity.Dog;
import com.checkpoint4.walkmybuddy.entity.DogOwner;
import com.checkpoint4.walkmybuddy.entity.DogWalker;
import com.checkpoint4.walkmybuddy.repository.DogOwnerRepository;
import com.checkpoint4.walkmybuddy.repository.DogRepository;
import com.checkpoint4.walkmybuddy.repository.DogWalkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class DogOwnerController {

    @Autowired
    private DogOwnerRepository dogOwnerRepository;

    @Autowired
    private DogWalkerRepository dogWalkerRepository;

    @Autowired
    private DogRepository dogRepository;

    @PostMapping("/dogOwners/signUp")
    public DogOwner signUpDogOwner(@RequestBody DogOwner dogOwner) {
        return dogOwnerRepository.save(dogOwner);
    }

    @PostMapping("/dogOwners/signIn")
    public DogOwner signInDogOwner(@RequestBody DogOwner dogOwner) {
        return dogOwnerRepository.findByEmailAndPassword(dogOwner.getEmail(), dogOwner.getPassword());
    }

    @PostMapping("dogOwners/{dogOwnerId}/dogWalkers/{dogWalkerId}")
    public DogWalker validateDogWalker(@PathVariable Long dogOwnerId, @PathVariable Long dogWalkerId) {
        DogOwner dogOwner = dogOwnerRepository.findById(dogOwnerId).get();
        DogWalker dogWalker = dogWalkerRepository.findById(dogWalkerId).get();
        Set<Dog> dogs = dogOwner.getDogsOwned();
        for (Dog dog : dogs) {
            dog.getDogWalkers().add(dogWalker);
            dogRepository.save(dog);
        }
        dogWalker.getDogs().addAll(dogOwner.getDogsOwned());
        return dogWalkerRepository.save(dogWalker);
    }
}
