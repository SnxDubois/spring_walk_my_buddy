package com.checkpoint4.walkmybuddy.repository;

import com.checkpoint4.walkmybuddy.entity.DogOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogOwnerRepository extends JpaRepository<DogOwner, Long> {
    DogOwner findByEmailAndPassword(String email, String password);
}
