package com.smith.social.api.entities;

import java.sql.Timestamp;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id; 
    private String username;
    
    private String userRole;
    private Timestamp created_at;
    
    @OneToMany(mappedBy = "user",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private Set<Posts> posts;
    
    // @OneToMany(mappedBy = "user",
    // cascade = CascadeType.ALL,
    // orphanRemoval = true)
    // private Set<Follows> following;
    
    // @OneToMany(mappedBy = "user",
    // cascade = CascadeType.ALL,
    // orphanRemoval = true)
    // private Set<Follows> followers;
    
    public Users(int id, String userName, String userRole, Timestamp created){
        this.id = id;
        this.username = userName;
        this.userRole = userRole;
        this.created_at = created;
        this.posts = null;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Set<Posts> getPosts() {
        return posts;
    }

    public void setPosts(Set<Posts> posts) {
        this.posts = posts;
    }

    public void addPost(Posts post){
        post.setUser(this);
        this.posts.add(post);
    }

    // public Set<Follows> getFollowing() {
    //     return following;
    // }

    // public void setFollowing(Set<Follows> following) {
    //     this.following = following;
    // }

    // public Set<Follows> getFollowers() {
    //     return followers;
    // }

    // public void setFollowers(Set<Follows> followers) {
    //     this.followers = followers;
    // }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Users other = (Users) obj;
        if (id != other.id)
            return false;
        if (created_at == null) {
            if (other.created_at != null)
                return false;
        } else if (!created_at.equals(other.created_at))
            return false;
        return true;
    }

    
}
