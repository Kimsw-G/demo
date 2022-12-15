package com.example.swtodo.service;

import java.util.List;

import com.example.swtodo.dto.SeeTodoDTO;
import com.example.swtodo.dto.TodoDTO;
import com.example.swtodo.entity.DiaryEntity;
import com.example.swtodo.entity.EventEntity;
import com.example.swtodo.entity.TodoEntity;
import com.example.swtodo.entity.SuserEntity;

public interface TodoService {
    
    // 새로운 일기, 이벤트, 할 일들을 추가
    public void writeDiary(DiaryEntity diaryEntity);
    public void addEvent(EventEntity eventEntity);
    public void addTodo(TodoDTO todoDTO);

    // 일기, 이벤트, 할 일들을 삭제
    public void delEvent(EventEntity eventEntity);
    public void delTodo(TodoEntity todoEntity);
    public void delDiary(DiaryEntity diaryEntity);

    // 일기 이벤트, 할 일들을 가져오기
    // 특정 일의 것들을 가져오는 것
    public List<DiaryEntity> getDiary(SuserEntity userEntity, String date);
    public List<EventEntity> getEvent(SuserEntity userEntity, String date);
    public List<SeeTodoDTO> getCurrentTodo(SuserEntity userEntity);
    public List<SeeTodoDTO> getExpiredTodo(SuserEntity userEntity);

    // 할 일, 이벤트들을 달력 화면에서 가져오기
    // 이벤트는 월 단위로 전부 가져오면 됨
    // 할 일들은 계산 후 퍼센테이지로 수치화 해서? 가져온다
    public void getEventThisMonth(SuserEntity userEntity,String date);
    public void getTodoPercentThisDay(SuserEntity userEntity,String date);
    public void getTodoPercentByNum();

    // 일기, 이벤트 할 일들을 수정하기
    public void modDiary(DiaryEntity diaryEntity);
    public void modEvent(EventEntity eventEntity);
    public void modTodo(TodoEntity todoEntity);

    // 할 일을 완료했을시, 업데이트
    public void doTodo(TodoEntity todoEntity);
    public void undoTodo(TodoEntity todoEntity);

}
