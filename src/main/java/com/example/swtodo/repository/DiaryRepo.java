package com.example.swtodo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swtodo.repository.custom.DiaryCustomRepo;

public interface DiaryRepo extends JpaRepository<DiaryRepo,Long>, DiaryCustomRepo{
    
}
