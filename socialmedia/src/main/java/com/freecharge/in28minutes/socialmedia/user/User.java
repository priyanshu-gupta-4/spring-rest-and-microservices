package com.freecharge.in28minutes.socialmedia.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freecharge.in28minutes.socialmedia.posts.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


import java.time.LocalDate;
import java.util.List;

@Entity(name="user_details")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Past(message="Birth date should be in past")
    //@JsonIgnore
    private LocalDate birthdate;
    @Size(min=2 , message="Name should be at least 2 characters")
    private String name;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    public User(){}

    public User(int id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
