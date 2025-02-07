package com.gabriel.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.gabriel.demo.entities.User;
import com.gabriel.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

}
