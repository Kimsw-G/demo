package com.example.swtodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swtodo.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity,Long>{
    
}
