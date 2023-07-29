package com.smith.social.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smith.social.api.entities.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{
    
}
