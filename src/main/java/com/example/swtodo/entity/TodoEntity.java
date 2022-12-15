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
@Entity(name = "todo")
@Table(name = "todo")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int pk;

    private String start_day;
    private String end_day;
    private String ttitle;
    private String ttext;
    private int suser;

    
}
