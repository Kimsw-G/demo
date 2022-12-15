package com.example.swtodo.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swtodo.entity.ExpenditureEntity;

@EntityScan("com.example.swtodo.entity")
public interface ExpenditureRepo extends JpaRepository<ExpenditureEntity,Long> {
    
}
