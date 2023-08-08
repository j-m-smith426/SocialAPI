package com.smith.social.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smith.social.api.entities.Posts;

public interface PostsRepo extends JpaRepository<Posts, Integer> {
    
}
