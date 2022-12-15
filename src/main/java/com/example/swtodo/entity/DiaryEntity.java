package com.example.swtodo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "diary")
@Table(name="diary")
public class DiaryEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int pk;
    
    private String dday;
    private String dtext;
    private int suser;
}
