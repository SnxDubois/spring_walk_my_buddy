package com.checkpoint4.walkmybuddy.controller;

import com.checkpoint4.walkmybuddy.entity.Dog;
import com.checkpoint4.walkmybuddy.entity.DogOwner;
import com.checkpoint4.walkmybuddy.repository.DogRepository;
import com.checkpoint4.walkmybuddy.repository.DogOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private DogOwnerRepository dogOwnerRepository;

    @PostMapping("/dogOwners/{dogOwnerId}/dogs")
    public Dog registerDog(@PathVariable Long dogOwnerId, @RequestBody Dog dog) {
        DogOwner dogOwner = dogOwnerRepository.findById(dogOwnerId).get();
        dog.setDogOwner(dogOwner);
        dogOwner.getDogsOwned().add(dog);
        dogOwnerRepository.save(dogOwner);
        return dogRepository.save(dog);
    }
}
