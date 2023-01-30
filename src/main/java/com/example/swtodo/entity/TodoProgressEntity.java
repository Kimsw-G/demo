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
@Entity(name = "todo_progress")
@Table(name="todo_progress")
public class TodoProgressEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int pk;
    
    private int todonum;
    private int flag;
    private String dday;
}