package com.checkpoint4.walkmybuddy.repository;

import com.checkpoint4.walkmybuddy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
