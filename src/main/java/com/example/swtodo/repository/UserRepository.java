package com.example.swtodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swtodo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{
    
}
