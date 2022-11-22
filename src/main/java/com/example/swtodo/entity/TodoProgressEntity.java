package com.example.swtodo.entity;

import javax.persistence.Entity;
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
    private int pk;
    
    private int todonum;
    private int check;
}
