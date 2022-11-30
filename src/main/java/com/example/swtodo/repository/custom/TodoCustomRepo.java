package com.example.swtodo.repository.custom;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.swtodo.entity.TodoEntity;

public interface TodoCustomRepo {
    
    @Query(value = "SELECT t FROM todo AS t WHERE t.suser = :user AND t.start_day BETWEEN :date AND LAST_DAY(:date) AND t.end_day BETWEEN :date AND LAST_DAY(:date)")
    List<TodoEntity> findAllByUserAndDate(int user, Date date);

    
}
