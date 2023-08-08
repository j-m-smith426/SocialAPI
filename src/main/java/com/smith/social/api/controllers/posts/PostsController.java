package com.smith.social.api.controllers.posts;

import org.springframework.web.bind.annotation.RestController;

import com.smith.social.api.entities.Posts;
import com.smith.social.api.entities.Users;
import com.smith.social.api.services.posts.PostService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/post")
public class PostsController {

    @Autowired
    private PostService postService;

    //Add posts
    @PostMapping(value="/")
    public Posts addPost(@RequestBody Posts entity) {
        Posts data = postService.addPost(entity);
        
        return data;
    }
    
    //Remove Posts
    @DeleteMapping("/{id}")
    public String removePost(@PathVariable int id){
        postService.deletePost(id);
        return "Success";
    }
    //Get All posts
    @GetMapping("/")
    public List<Posts> getAllPosts(){
        List<Posts> data = postService.getAllPosts();
        return data;
    }
    //Get All posts by user
    @GetMapping("/")
    public List<Posts> getAllPosts(@RequestBody Users user){
        List<Posts> data = postService.getAllPosts(user);
        return data;
    }
    //Get All posts by follow
}
