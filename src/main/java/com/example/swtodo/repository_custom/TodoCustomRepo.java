package com.example.swtodo.repository_custom;

import java.util.List;


import com.example.swtodo.entity.TodoEntity;

public interface TodoCustomRepo {
    
    List<TodoEntity> findAllBySuser(int user, String today);
    List<TodoEntity> findAllCurrentTodo(int suser, String today);
    List<TodoEntity> findAllExpiredTodo(int suser, String today);
    
}
