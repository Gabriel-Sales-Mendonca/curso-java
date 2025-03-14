package com.gabrielsales.workshop.controllers;

import com.gabrielsales.workshop.domain.User;
import com.gabrielsales.workshop.dto.UserDTO;
import com.gabrielsales.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserDTO obj) {
        User user = service.fromDTO(obj);
        User userCreated = service.insert(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(userCreated.getId()).toUri();
        return ResponseEntity.created(uri).body(userCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody UserDTO obj) {
        User user = service.fromDTO(obj);
        User userUpdated = service.update(user);
        return ResponseEntity.ok().body(userUpdated);
    }

}
