package com.smith.social.api.controllers.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smith.social.api.entities.Users;
import com.smith.social.api.services.users.UsersService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsersController {
    
    @Autowired
    private UsersService usersService;

    /**
     * 
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> data = usersService.getAllUsers();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    /**
     * 
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id){
        Users data = usersService.getUserById(id);
        return new ResponseEntity<Users>(data, HttpStatus.OK);
    }

    /**
     * 
     * @param user
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Users> addUser(@RequestBody Users user){
        Users data = usersService.addUser(user);
        return new ResponseEntity<Users>(data, HttpStatus.OK);
    }

    /**
     * 
     * @param user
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<Users> updateUser(@RequestBody Users user){
        Users data = usersService.updateUser(user);
        return new ResponseEntity<Users>(data, HttpStatus.OK);
    }

    /**
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        usersService.deleteUser(id);
        return new ResponseEntity<String>("User with id: " + id + " was successfully deleted", HttpStatus.OK);
    }
}
