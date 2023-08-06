package com.smith.social.api.entities;

import java.sql.Timestamp;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Follows {
    @EmbeddedId
    private FollowId followId;
    private Timestamp created_at;

    
}
