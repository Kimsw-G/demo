package com.example.swtodo.repository_custom;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.swtodo.entity.EventEntity;

public class EventCustomRepoImpl implements EventCustomRepo{

    @Autowired
    EntityManager em;

    @Override
    public List<EventEntity> findAllByDate(int user, String eday){
        final String SQL = "SELECT e FROM event AS e WHERE e.suser = :user AND e.dday BETWEEN :eday AND LAST_DAY(:eday)";
        List<EventEntity> result = em.createQuery(SQL,EventEntity.class).getResultList();
        return result;
    }
    
}
