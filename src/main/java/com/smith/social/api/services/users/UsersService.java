package com.smith.social.api.services.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smith.social.api.entities.Users;
import com.smith.social.api.error.DatabaseManipulationException;
import com.smith.social.api.error.UserNotFoundException;
import com.smith.social.api.repository.UsersRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;

    public List<Users> getAllUsers() {
        List<Users> data = usersRepo.findAll();
        //No Users Found
        return data;
    }

    public Users getUserById(int id) throws UserNotFoundException {
        try {
            Optional<Users> data = usersRepo.findById(id);
            //User not found
            if(data.isEmpty()){
                throw new UserNotFoundException("User id not valid");
            }
            return data.get();
            
        } catch (Exception e) {
            throw new UserNotFoundException("User id not valid");
        }
            
    }

    public Users updateUser(Users user) {
        try {
            this.getUserById(user.getId());
            Users data = usersRepo.save(user);
            return data;
            
        } catch (Exception e) {
            //User not found
            throw new UserNotFoundException("User id not valid");
        }
    }

    public Users addUser(Users user) {
        try {
            Users data = usersRepo.save(user);
            return data;
        } catch (Exception e) {
            //Error adding user
            throw new DatabaseManipulationException(e.getMessage());
        }
    }

    public int deleteUser(int id) {
        try {
            usersRepo.deleteById(id);
            return 1;
        } catch (Exception e) {
            //Error deleting user
            throw new DatabaseManipulationException(e.getMessage());
        }
        
    }
    
}
