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
@Entity(name = "todo")
@Table(name = "todo")
public class TodoEntity {
    @Id
    @GeneratedValue
    private int pk;

    private Date start_day;
    private Date end_day;
    private String ttitle;
    private String ttext;
    private int suser;
}
