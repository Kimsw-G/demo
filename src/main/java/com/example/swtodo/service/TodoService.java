package com.example.swtodo.service;

import com.example.swtodo.entity.DiaryEntity;
import com.example.swtodo.entity.TodoEntity;
import com.example.swtodo.entity.UserEntity;

public interface TodoService {
    
    // 새로운 일기, 이벤트, 할 일들을 추가
    public void writeDiary(DiaryEntity diaryEntity);
    public void addEvent(TodoEntity todoEntity);
    public void addTodo(TodoEntity todoEntity);

    // 일기, 이벤트, 할 일들을 삭제
    public void delEvent(TodoEntity todoEntity);
    public void delTodo(TodoEntity todoEntity);
    public void delDiary(DiaryEntity diaryEntity);

    // 일기 이벤트, 할 일들을 가져오기
    // 특정 일의 것들을 가져오는 것
    public void getDiary(UserEntity userEntity, int month);
    public void getEvent(UserEntity userEntity, int month);
    public void getTodo(UserEntity userEntity, int month);

    // 할 일, 이벤트들을 달력 화면에서 가져오기
    // 이벤트는 월 단위로 전부 가져오면 됨
    // 할 일들은 계산 후 퍼센테이지로 수치화 해서? 가져온다
    public void getEventThisMonth();
    public void getTodoPercentThisMonth();

    // 일기, 이벤트 할 일들을 수정하기
    public void modDiary();
    public void modEvent();
    public void modTodo();

    // 할 일을 완료했을시, 업데이트
    public void doTodo();
    public void undoTodo();

}
