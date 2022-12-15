package com.example.swtodo.dto;


import com.example.swtodo.entity.TodoEntity;

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

    public TodoEntity getTodoEntity(){
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setStart_day(this.start_day);
        todoEntity.setEnd_day(this.end_day);
        todoEntity.setTtitle(this.ttitle);
        todoEntity.setTtext(this.ttext);
        todoEntity.setSuser(this.suser);

        return todoEntity;
    }
}
