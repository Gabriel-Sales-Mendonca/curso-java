package com.gabrielsales.workshop.controllers;

import com.gabrielsales.workshop.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Brown", "maria@email.com");
        User alex = new User("2", "Alex Green", "alex@email.com");

        List<User> users = Arrays.asList(maria, alex);

        return ResponseEntity.ok().body(users);
    }

}
