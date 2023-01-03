package com.example.swtodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swtodo.entity.FeedEntity;
import com.example.swtodo.repository_custom.FeedCustomRepo;

public interface FeedRepo extends JpaRepository<FeedEntity,Long>, FeedCustomRepo{
    
}
