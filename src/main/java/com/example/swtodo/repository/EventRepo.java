package com.example.swtodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swtodo.entity.EventEntity;
import com.example.swtodo.repository.custom.EventCustomRepo;

public interface EventRepo extends JpaRepository<EventEntity,Long>, EventCustomRepo{
    
}
