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
    private String text;
    // flag를 통해 해당 todo의 타입을 설정한다
    // 1은 이벤트
    // 2는 할 일
    // 3은 할 일(완료)
    private int flag;
    private int frequency;
    private int user;
}
