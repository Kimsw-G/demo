package com.example.swtodo.dto;

import com.example.swtodo.entity.FeedEntity;

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
    private String ftitle;
    private String ftext;
    private int suser;
    private int percent;

    public void insertObject(FeedEntity todoEntity){
        this.pk = todoEntity.getPk();
        this.start_day = todoEntity.getStart_day();
        this.end_day = todoEntity.getEnd_day();
        this.ftitle = todoEntity.getFtitle();
        this.ftext = todoEntity.getFtext();
        this.suser = todoEntity.getSuser();
    }
}
