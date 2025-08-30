package com.example.crmdemo.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crmdemo.main.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User>findByEmail(String email);
   

}
