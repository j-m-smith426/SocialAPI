package com.smith.social.api.services.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smith.social.api.entities.Posts;
import com.smith.social.api.entities.Users;
import com.smith.social.api.repository.PostsRepo;

@Service
public class PostService {

    @Autowired
    PostsRepo postsRepo;

    //Add posts
    public Posts addPost(Posts entity) {
        Posts data = postsRepo.save(entity);
        return data;
    }
    //Get All posts
    public List<Posts> getAllPosts() {
        List<Posts> posts = postsRepo.findAll();
        return posts;
    }

    //Get All posts by user
    public List<Posts> getAllPosts(Users user) {
        return null;
    }
    
    //Remove Posts
    public void deletePost(int id) {
        postsRepo.deleteById(id);
    }
    
    
    //Get All posts by follow
}
