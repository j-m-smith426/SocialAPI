package com.smith.social.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.smith.social.api.controllers.users.UsersController;
import com.smith.social.api.entities.Follows;
import com.smith.social.api.entities.Posts;
import com.smith.social.api.repository.UsersRepo;
import com.smith.social.api.services.users.UsersService;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application-integrationtest.properties")
class ApiApplicationTests {

	@Autowired
	UsersController usersController;

	@Autowired
	UsersService usersService;

	@Autowired
	UsersRepo usersRepo;

	// @Autowired
	// Posts posts;

	@Test
	void contextLoads() {
		assertNotNull(usersController);
		assertNotNull(usersService);
		assertNotNull(usersRepo);
		// assertNotNull(posts);
	}

}
