package com.oiannace.forumapi.method;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;

    private ArrayList<Comment> threadComments;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public AppUser(){
    }
    public AppUser(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
        this.threadComments = new ArrayList<Comment>();
    }
    public Collection<Role> getRoles(){
        return this.roles;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public void addComment(String content){
        this.threadComments.add(new Comment(content));
    }
    public void setPassword(String encode) {
        this.password = encode;
    }
}
