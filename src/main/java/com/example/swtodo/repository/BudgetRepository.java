package com.example.swtodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swtodo.entity.BudgetEntity;

public interface BudgetRepository extends JpaRepository<BudgetEntity,Long> {
    
}
