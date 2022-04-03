package com.oiannace.forumapi.method;


import javax.persistence.*;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Role(){
    }
    public Role(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
