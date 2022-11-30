package com.example.swtodo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "event")
@Table(name = "event")
public class EventEntity {
    
    @Id
    private int pk;

    private String etitle;
    private String etext;
    private int suser;
    private Date dday;
}
