package com.gabrielsales.workshop.repositories;

import com.gabrielsales.workshop.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query
    public List<Post> findByTitleContainingIgnoreCase(String text);

}
