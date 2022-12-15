package com.example.swtodo.repository_custom;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.swtodo.entity.DiaryEntity;

public class DiaryCustomRepoImpl implements DiaryCustomRepo{

    @Autowired
    EntityManager em;

    @Override
    public List<DiaryEntity> findDiaryByUserAndDate(int user,String eday){
        final String SQL = "SELECT d.* FROM diary AS d WHERE d.suser = :user AND d.dday BETWEEN :eday AND LAST_DAY(:eday)";
        List<DiaryEntity> result = em.createQuery(SQL,DiaryEntity.class).getResultList();
        return result;
    }
    
}
