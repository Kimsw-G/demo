package com.example.swtodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swtodo.entity.TodoProgressEntity;
import com.example.swtodo.repository_custom.TodoProgressCustomRepo;


public interface TodoProgressRepo extends JpaRepository<TodoProgressEntity,Long>, TodoProgressCustomRepo{
    
}