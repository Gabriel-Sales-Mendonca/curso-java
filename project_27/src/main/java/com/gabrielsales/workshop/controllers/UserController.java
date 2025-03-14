package com.gabrielsales.workshop.controllers;

import com.gabrielsales.workshop.domain.User;
import com.gabrielsales.workshop.dto.UserDTO;
import com.gabrielsales.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = service.findAll();
        List<UserDTO> userDTO = users.stream().map(user -> new UserDTO(user)).toList();
        return ResponseEntity.ok().body(userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable String id) {
        User user = service.findById(id);
        return new UserDTO(user);
    }

}
