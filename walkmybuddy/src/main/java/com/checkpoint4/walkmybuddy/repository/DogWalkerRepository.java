package com.checkpoint4.walkmybuddy.repository;

import com.checkpoint4.walkmybuddy.entity.DogWalker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogWalkerRepository extends JpaRepository<DogWalker, Long> {
    DogWalker findByEmailAndPassword(String email, String password);
}
