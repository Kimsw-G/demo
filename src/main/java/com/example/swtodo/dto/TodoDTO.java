package com.example.swtodo.dto;


import com.example.swtodo.entity.FeedEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoDTO{
    private String start_day;
    private String end_day;
    private String ttitle;
    private String ttext;
    private int suser;
    private int freq;

    public FeedEntity getTodoEntity(){
        FeedEntity todoEntity = new FeedEntity();
        todoEntity.setStart_day(this.start_day);
        todoEntity.setEnd_day(this.end_day);
        todoEntity.setFtitle(this.ttitle);
        todoEntity.setFtext(this.ttext);
        todoEntity.setSuser(this.suser);

        return todoEntity;
    }
}
