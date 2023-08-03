package com.smith.social.api.controllers;

import static org.mockito.Mockito.when;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smith.social.api.controllers.users.UsersController;
import com.smith.social.api.entities.Users;
import com.smith.social.api.services.users.UsersService;



@WebMvcTest(controllers = UsersController.class)
public class UsersControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsersService usersService;

    @Autowired
    private ObjectMapper objectMapper;

    //Validate get All endpoint
    @Test
    public void givenUsers_whenGetUsers_thenReturnJsonArray() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/user/all")
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // getById
    @Test
    public void givenId_willReturnUser() throws Exception {
        Users user = new Users(5, "Bob", "user", new Timestamp(0));
        when(usersService.getUserById(5)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}",5)
                .contentType("application/json"))
                .andExpectAll(
                    MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(user)),
                    MockMvcResultMatchers.status().isOk()
                    );
    }

    //Validate add endpoint and functionality
    @Test
    public void whenValidInput_thenReturns200() throws Exception {
        Users user = new Users(0, "Bob", "user", new Timestamp(0));
        when(usersService.addUser(user)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user)))
                        .andExpectAll(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(user)),
                        MockMvcResultMatchers.status().isOk());
    }

    // update
    @Test
    public void givenUsers_whenUpdatingUsers_returnsUpdatedUser() throws Exception {
        Users user = new Users(5, "Bob", "user", new Timestamp(0));
        
        when(usersService.updateUser(user)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/update")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user)))
                        .andExpectAll(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(user)),
                        MockMvcResultMatchers.status().isOk());
    }

    // delete
    @Test
    public void givenId_whenDeletingUsers_returns200() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/user/delete/{id}", 5)
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }



}
