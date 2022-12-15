package com.example.swtodo.repository_custom;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.swtodo.entity.TodoEntity;

import java.util.List;

public class TodoCustomRepoImpl implements TodoCustomRepo{
    @Autowired
    EntityManager em;
    
    @Override
    public List<TodoEntity> findAllBySuser(int user, String today){
        final String SQL = "SELECT t FROM todo AS t "+
                            "WHERE t.suser = :user AND t.start_day BETWEEN :today AND LAST_DAY(:today) AND t.end_day BETWEEN :today AND LAST_DAY(:today)";
        List<TodoEntity> result = em.createQuery(SQL,TodoEntity.class)
            .setParameter("user", user)
            .setParameter("today", today)
            .getResultList();
        return result;
    }

    @Override
    public List<TodoEntity> findAllCurrentTodo(int suser, String today) {
        final String SQL = "SELECT t FROM todo AS t "+
                            "WHERE t.suser=:suser "+
                            "AND :today BETWEEN t.start_day AND t.end_day";
        List<TodoEntity> result = em.createQuery(SQL,TodoEntity.class)
            .setParameter("suser", suser)
            .setParameter("today", today)
            .getResultList();
        return result;
    }

    @Override
    public List<TodoEntity> findAllExpiredTodo(int suser, String today) {
        final String SQL = "SELECT t FROM todo AS t "+
                            "WHERE t.suser=:suser "+
                            "AND t.end_day < :today";
        List<TodoEntity> result = em.createQuery(SQL,TodoEntity.class)
            .setParameter("suser", suser)
            .setParameter("today", today)
            .getResultList();
        return result;
    }

}
