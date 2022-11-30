package com.example.swtodo.repository.custom;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.swtodo.entity.DiaryEntity;



public interface DiaryCustomRepo {

    @Query(value = "SELECT d FROM diary AS d WHERE d.suser = :user AND d.dday BETWEEN :date AND LAST_DAY(:date)")
    List<DiaryEntity> findDiaryByUserAndDate(int user,Date date);
    
}
