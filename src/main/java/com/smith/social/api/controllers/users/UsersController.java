package com.smith.social.api.controllers.users;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> data = usersService.getAllUsers();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
