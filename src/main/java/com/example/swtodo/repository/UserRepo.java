package com.example.swtodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swtodo.entity.SuserEntity;

public interface UserRepo extends JpaRepository<SuserEntity,Long>{
    
}
