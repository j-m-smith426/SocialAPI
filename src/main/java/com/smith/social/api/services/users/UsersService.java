package com.smith.social.api.services.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smith.social.api.entities.Users;
import com.smith.social.api.repository.UsersRepo;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;

    public List<Users> getAllUsers() {
        List<Users> data = usersRepo.findAll();
        return null;
    }

    public Object getUserById(int i) {
        return null;
    }

    public Object updateUser(Users user) {
        return null;
    }
    
}
