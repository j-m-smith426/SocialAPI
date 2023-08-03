package com.smith.social.api.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.smith.social.api.entities.Users;
import com.smith.social.api.error.DatabaseManipulationException;
import com.smith.social.api.error.UserNotFoundException;
import com.smith.social.api.repository.UsersRepo;
import com.smith.social.api.services.users.UsersService;

@ExtendWith(SpringExtension.class)
public class UsersServiceTests {
    
    @InjectMocks
    private UsersService usersService;

    @Mock
    private UsersRepo usersRepo;

    //Get all Users
    @Test
    public void whenRetrievingUsers_ReturnsListofUsers(){
        List<Users> mockData = Arrays.asList(new Users(2, "Dull", "user", new Timestamp(0)));
        when(usersRepo.findAll()).thenReturn(mockData);
        List<Users> data = usersService.getAllUsers();
        assert(data.size() == 1);
        
    }

    //Get User by Id
    @Test
    public void whenRequestingUser_withValidId_ReturnsUser(){
        Users user = new Users(5, "five", "user", new Timestamp(0));
        Optional<Users> options = Optional.of(user);
        when(usersRepo.findById(5)).thenReturn(options);
        Users data = usersService.getUserById(5);
        assertTrue(data != null);
    }

    //No User Found
    @Test
    public void whenRequestingUser_withInvalidId_ThrowNoUserFoundException(){
        when(usersRepo.findById(5)).thenReturn(null);
        assertThrows(UserNotFoundException.class, () -> {
            usersService.getUserById(5);
        });
        

    }

    //Add User
    @Test
    public void whenAddingUser_returnsUserInfo(){
        Users user = new Users(5, "five", "user", new Timestamp(0));
        when(usersRepo.save(user)).thenReturn(user);
        Users result = usersService.addUser(user);
        assertSame(user, result);    
    }

    //Faild to add User
    @Test
    public void whenAddingUser_ErrorOccurred_DatabaseManipulationExceptionThrown(){
        Users user = new Users(5, "five", "user", new Timestamp(0));
        when(usersRepo.save(user)).thenThrow(new IllegalArgumentException());
        assertThrows(DatabaseManipulationException.class, () -> {
            usersService.addUser(user);
        });
    }

    //Update User
    @Test
    public void whenUpdatingUser_returnsUpdatedUser(){
        Users user = new Users(5, "five", "user", new Timestamp(0));
        Optional<Users> options = Optional.of(user);
        when(usersRepo.findById(5)).thenReturn(options);
        when(usersRepo.save(user)).thenReturn(user);
        Users result = usersService.updateUser(user);
        assertSame(user, result);
    }
    
    //Failed to update User
    @Test
    public void whenUpdatingUser_withInvalidId_ThrowNoUserFoundException(){
        Users user = new Users(5, "five", "user", new Timestamp(0));
        when(usersRepo.findById(5)).thenReturn(null);
        assertThrows(UserNotFoundException.class, () -> {
            usersService.updateUser(user);
        });
    }

    //delete User
    @Test
    public void givenId_whenDeletingUsers_NoExceptionThrown(){
        assertDoesNotThrow(() -> usersService.deleteUser(5));
    }
    //Fail to delete User
    // @Test
    // public void givenInvalidId_whenDeletingUsers_ExceptionIsThrown(){
    //     assertThrows(DatabaseManipulationException.class, () -> usersService.deleteUser());
    // }
}
