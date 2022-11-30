package com.example.swtodo.repository.custom;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.swtodo.entity.EventEntity;

public interface EventCustomRepo {
    
    @Query(value = "SELECT e FROM event AS e WHERE d.suser = :user AND d.dday BETWEEN :date AND LAST_DAY(:date)")
    public List<EventEntity> findAllByDate(int user, Date date);
}
