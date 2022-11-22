package com.example.swtodo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user")
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue
    private int pk;

    private String id;
    private String password;
    
}
