package com.gabrielsales.workshop.services;

import com.gabrielsales.workshop.domain.User;
import com.gabrielsales.workshop.repositories.UserRepository;
import com.gabrielsales.workshop.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id = " + id));
    }

}
