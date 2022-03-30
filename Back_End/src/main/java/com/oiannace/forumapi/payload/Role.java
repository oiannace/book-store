package com.oiannace.forumapi.payload;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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
}
