package com.smith.social.api.controllers;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.smith.social.api.controllers.users.UsersController;
import com.smith.social.api.entities.Users;
import com.smith.social.api.services.users.UsersService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UsersController.class)
public class UsersControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsersService usersService;

    @Test
    public void givenUsers_whenGetUsers_thenReturnJsonArray() throws Exception {

        Users user = new Users(0, "Bob", "user", new Timestamp(0));
        List<Users> userList = Arrays.asList(user);

        mockMvc.perform(MockMvcRequestBuilders.get("/user/all").contentType("application/json")).andExpect(MockMvcResultMatchers.status().isOk());
    }


}
