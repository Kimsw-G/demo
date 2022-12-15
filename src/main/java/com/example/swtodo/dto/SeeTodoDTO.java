package com.example.swtodo.dto;

import com.example.swtodo.entity.TodoEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeeTodoDTO{
    private int pk;
    private String start_day;
    private String end_day;
    private String ttitle;
    private String ttext;
    private int suser;
    private int percent;

    public void insertObject(TodoEntity todoEntity){
        this.pk = todoEntity.getPk();
        this.start_day = todoEntity.getStart_day();
        this.end_day = todoEntity.getEnd_day();
        this.ttitle = todoEntity.getTtitle();
        this.ttext = todoEntity.getTtext();
        this.suser = todoEntity.getSuser();
    }
}
