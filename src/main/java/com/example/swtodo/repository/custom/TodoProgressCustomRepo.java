package com.example.swtodo.repository.custom;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;

public interface TodoProgressCustomRepo {

    @Query(value = "UPDATE todo_progress as tp SET tp.flag = 1 WHERE as tp.pk = :pk")
    void doCheck(int pk);

    @Query(value = "UPDATE todo_progress as tp SET tp.flag = 0 WHERE as tp.pk = :pk")
    void undoCheck(int pk);

    String SQL = "SELECT COUNT(CASE WHEN tp.todonum IN(SELECT t FROM todo AS t WHERE t.suser = :user) AND tp.dday = :date AND tp.flag = 1)/COUNT(CASE WHEN tp.todonum IN(SELECT t FROM todo AS t WHERE t.suser = :user) AND tp.dday = :date) FROM todo_progress as tp";
    @Query(value = SQL)
    void calcPercentage(int user, Date date);
    
}
