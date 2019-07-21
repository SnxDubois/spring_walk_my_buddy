package com.checkpoint4.walkmybuddy.repository;

import com.checkpoint4.walkmybuddy.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
}
