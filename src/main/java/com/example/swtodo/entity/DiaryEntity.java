package com.example.swtodo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    private int pk;
    
    private Date dday;
    private String dtext;
    private int suser;
}
