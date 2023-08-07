package com.smith.social.api.entities;

import java.sql.Timestamp;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Follows {
    @EmbeddedId
    private FollowId followId;
    
    private Timestamp created_at;

    
}
