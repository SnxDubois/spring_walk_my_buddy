package com.checkpoint4.walkmybuddy.controller;

import com.checkpoint4.walkmybuddy.entity.Dog;
import com.checkpoint4.walkmybuddy.entity.DogOwner;
import com.checkpoint4.walkmybuddy.entity.DogWalker;
import com.checkpoint4.walkmybuddy.repository.DogOwnerRepository;
import com.checkpoint4.walkmybuddy.repository.DogRepository;
import com.checkpoint4.walkmybuddy.repository.DogWalkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class DogController {

    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private DogOwnerRepository dogOwnerRepository;
    @Autowired
    private DogWalkerRepository dogWalkerRepository;

    @PostMapping("/dogOwners/{dogOwnerId}/dogs")
    public Dog registerDog(@PathVariable Long dogOwnerId, @RequestBody Dog dog) {
        DogOwner dogOwner = dogOwnerRepository.findById(dogOwnerId).get();
        dog.setDogOwner(dogOwner);
        return dogRepository.save(dog);
    }

    @GetMapping("/dogWalkers/{dogWalkerId}/dogs/")
    public Set<Dog> getAllDogsByWalker(@PathVariable Long dogWalkerId) {
        DogWalker dogWalker = dogWalkerRepository.findById(dogWalkerId).get();
        return dogWalker.getDogs();
    }
}
