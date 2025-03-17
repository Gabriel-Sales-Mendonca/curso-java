package com.gabrielsales.workshop.controllers;

import com.gabrielsales.workshop.controllers.util.URL;
import com.gabrielsales.workshop.domain.Post;
import com.gabrielsales.workshop.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/titleSearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        String textDecoded = URL.decodeParam(text);
        List<Post> posts = service.findByTitle(textDecoded);
        return ResponseEntity.ok().body(posts);
    }

}
