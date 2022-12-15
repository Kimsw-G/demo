package com.example.swtodo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swtodo.entity.DiaryEntity;
import com.example.swtodo.repository_custom.DiaryCustomRepo;

public interface DiaryRepo extends JpaRepository<DiaryEntity,Long>, DiaryCustomRepo{
    
}
