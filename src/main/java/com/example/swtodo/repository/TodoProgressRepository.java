package com.example.swtodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swtodo.entity.TodoProgressEntity;

public interface TodoProgressRepository extends JpaRepository<TodoProgressEntity,Long> {
    
}
