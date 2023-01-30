package com.example.swtodo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name="suser")
@Table(name="suser")
public class SuserEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int pk;

    private String sid;
    private String spassword;
}