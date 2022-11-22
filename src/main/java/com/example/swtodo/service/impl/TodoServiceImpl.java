package com.example.swtodo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.swtodo.entity.DiaryEntity;
import com.example.swtodo.entity.TodoEntity;
import com.example.swtodo.entity.TodoProgressEntity;
import com.example.swtodo.entity.UserEntity;
import com.example.swtodo.repository.DiaryRepositroy;
import com.example.swtodo.repository.TodoRepository;
import com.example.swtodo.service.TodoService;

public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    DiaryRepositroy diaryRepositroy;
    @Autowired
    TodoProgressEntity todoProgressEntity;
    

    @Override
    public void writeDiary(DiaryEntity diaryEntity) {
        // TODO Auto-generated method stub
        diaryRepositroy.save(diaryRepositroy);
    }

    @Override
    public void addEvent(TodoEntity todoEntity) {
        // TODO Auto-generated method stub
        todoEntity.setFlag(1);
        todoRepository.save(todoEntity);
    }

    @Override
    public void addTodo(TodoEntity todoEntity) {
        // TODO Auto-generated method stub
        todoEntity.setFlag(2);
        todoRepository.save(todoEntity);
    }

    // 두 코드가 중복되는데 줄이는게 좋지않을까?
    @Override
    public void delEvent(TodoEntity todoEntity) {
        todoRepository.delete(todoEntity);
    }

    @Override
    public void delTodo(TodoEntity todoEntity) {
        // TODO Auto-generated method stub
        todoRepository.delete(todoEntity);
    }

    @Override
    public void delDiary(DiaryEntity diaryEntity) {
        // TODO Auto-generated method stub
        diaryRepositroy.delete(diaryRepositroy);
    }

    @Override
    public void getDiary(UserEntity userEntity, int month) {
        // TODO Auto-generated method stub
        diaryRepositroy.findDiaryByUserAndMonth();
        
    }

    @Override
    public void getEvent(UserEntity userEntity, int month) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getTodo(UserEntity userEntity, int month) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getEventThisMonth() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getTodoPercentThisMonth() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void modDiary() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void modEvent() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void modTodo() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doTodo() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void undoTodo() {
        // TODO Auto-generated method stub
        
    }
    
}
