package com.example.swtodo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.swtodo.entity.DiaryEntity;
import com.example.swtodo.entity.EventEntity;
import com.example.swtodo.entity.TodoEntity;
import com.example.swtodo.entity.SuserEntity;
import com.example.swtodo.repository.DiaryRepo;
import com.example.swtodo.repository.EventRepo;
import com.example.swtodo.repository.TodoProgressRepo;
import com.example.swtodo.repository.TodoRepo;
import com.example.swtodo.service.TodoService;

public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoRepo todoRepo;
    @Autowired
    DiaryRepo diaryRepo;
    @Autowired
    EventRepo eventRepo;
    @Autowired
    TodoProgressRepo todoProgressRepo;
    
    @Override
    public void writeDiary(DiaryEntity diaryEntity) {
        diaryRepo.save(diaryRepo);
    }

    @Override
    public void addEvent(EventEntity eventEntity) {
        eventRepo.save(eventEntity);
    }

    @Override
    public void addTodo(TodoEntity todoEntity) {
        todoRepo.save(todoEntity);
    }

    @Override
    public void delEvent(EventEntity eventEntity) {
        eventRepo.delete(eventEntity);
    }

    @Override
    public void delTodo(TodoEntity todoEntity) {
        todoRepo.delete(todoEntity);
    }

    @Override
    public void delDiary(DiaryEntity diaryEntity) {
        diaryRepo.delete(diaryRepo);
    }

    @Override
    public List<DiaryEntity> getDiary(SuserEntity userEntity, Date date) {
        // Diary를 특정 유저의 특정 기간만 가져오는 쿼리
        return diaryRepo.findDiaryByUserAndDate(userEntity.getPk(), date);
        
    }

    @Override
    public List<TodoEntity> getEvent(SuserEntity userEntity, Date date) {
        // 특정 Diary를 특정 유저 및 특정 기간만 가져오는 쿼리
        return todoRepo.findAllByUserAndDate(userEntity.getPk(),date);
        
    }

    @Override
    public List<TodoEntity> getTodo(SuserEntity userEntity, Date date) {
        return todoRepo.findAllByUserAndDate(userEntity.getPk(),date);
    }

    @Override
    public void getEventThisMonth(SuserEntity userEntity, Date date) {
        eventRepo.findAllByDate(userEntity.getPk(), date);
        
    }

    @Override
    public void getTodoPercentThisDay(SuserEntity userEntity,Date date) {
        
        
    }

    @Override
    public void getTodoPercentByNum(){

    }

    @Override
    public void modDiary(DiaryEntity diaryEntity) {
        diaryRepo.save(diaryRepo);
    }

    @Override
    public void modEvent(EventEntity eventEntity) {
        eventRepo.save(eventEntity);
    }

    @Override
    public void modTodo(TodoEntity todoEntity) {
        todoRepo.save(todoEntity);
    }

    @Override
    public void doTodo(TodoEntity todoEntity) {
        todoProgressRepo.doCheck(todoEntity.getPk());
    }

    @Override
    public void undoTodo(TodoEntity todoEntity) {
        todoProgressRepo.undoCheck(todoEntity.getPk());
    }
    
}
