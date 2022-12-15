package com.example.swtodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swtodo.entity.TodoEntity;
import com.example.swtodo.repository_custom.TodoCustomRepo;


public interface TodoRepo extends JpaRepository<TodoEntity,Long>,TodoCustomRepo{
    
}
