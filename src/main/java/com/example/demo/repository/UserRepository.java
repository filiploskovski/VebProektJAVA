package com.example.demo.repository;

import com.example.demo.entities.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public interface UserRepository extends JpaRepository<User, Integer> {

    User findFirstByEmail(String email);
    User findFirstByUsername(String username);
    Boolean existsUserByEmail(String email);
    Boolean existsUserByUsernameAndPassword(String username, String password);
}
