package com.example.swtodo.repository_custom;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;

public interface TodoProgressCustomRepo {

    // 해당 일을 했는지 체크하기
    @Transactional
    @Modifying
    void doCheck(int pk);
    @Transactional
    @Modifying
    void undoCheck(int pk);
    
    // 
    int calcPercentageByNumAndPk(int pk);

    @Transactional
    @Modifying
    void insertTodoProgress(int todonum,List<String> string);
}
