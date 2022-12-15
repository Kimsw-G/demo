package com.example.swtodo.repository_custom;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;

public interface TodoProgressCustomRepo {

    @Transactional
    @Modifying
    void doCheck(int pk);

    @Transactional
    @Modifying
    void undoCheck(int pk);
    
    int calcPercentageByNumAndPk(int pk);

    @Transactional
    @Modifying
    void insertTodoProgress(int todonum,List<String> string);
}
