package com.example.swtodo.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.example.swtodo.dto.SeeTodoDTO;
import com.example.swtodo.dto.TodoDTO;
import com.example.swtodo.entity.FeedEntity;
import com.example.swtodo.entity.SuserEntity;

public interface FeedService {
    
    // 새로운 일기, 이벤트, 할 일들을 추가
    public void addDiary(FeedEntity feedEntity);
    public void addEvent(FeedEntity feedEntity);
    public void addTodo(TodoDTO feedEntity);

    // 일기, 이벤트, 할 일들을 삭제
    public void delEvent(FeedEntity feedEntity);
    public void delTodo(FeedEntity feedEntity);
    public void delDiary(FeedEntity feedEntity);

    // 일기 이벤트, 할 일들을 가져오기
    // 특정 일의 것들을 가져오는 것
    public List<FeedEntity> getDiary(SuserEntity userEntity, String date);
    public List<FeedEntity> getEvent(SuserEntity userEntity, String date);
    public List<SeeTodoDTO> getCurrentTodo(SuserEntity userEntity);
    public List<SeeTodoDTO> getExpiredTodo(SuserEntity userEntity);
    public List<FeedEntity> getSpecDay(SuserEntity userEntity,String date, String page);

    // 할 일, 이벤트들을 달력 화면에서 가져오기
    // 이벤트는 월 단위로 전부 가져오면 됨
    // 할 일들은 계산 후 퍼센테이지로 수치화 해서? 가져온다
    public void getEventThisMonth(SuserEntity userEntity,String date);
    public void getTodoPercentThisDay(SuserEntity userEntity,String date);
    public void getTodoPercentByNum();

    // 일기, 이벤트 할 일들을 수정하기
    public void modDiary(FeedEntity feedEntity);
    public void modEvent(FeedEntity feedEntity);
    public void modTodo(FeedEntity feedEntity);

    // 할 일을 완료했을시, 업데이트
    public void doTodo(FeedEntity feedEntity);
    public void undoTodo(FeedEntity feedEntity);

}
