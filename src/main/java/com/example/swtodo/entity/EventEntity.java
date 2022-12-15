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
@Entity(name = "event")
@Table(name = "event")
public class EventEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int pk;

    private String etitle;
    private String etext;
    private int suser;
    private String dday;



}
