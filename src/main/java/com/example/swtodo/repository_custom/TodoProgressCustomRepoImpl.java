package com.example.swtodo.repository_custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;

public class TodoProgressCustomRepoImpl implements TodoProgressCustomRepo {
    @Autowired
    EntityManager em;

    @Override
    public void doCheck(int pk) {
        final String SQL = "UPDATE todo_progress as tp SET tp.flag = 1 WHERE tp.pk = :pk";
        em.createQuery(SQL)
            .setParameter("pk", pk)
            .executeUpdate();
        em.clear();
    }

    @Override
    public void undoCheck(int pk) {
        final String SQL = "UPDATE todo_progress as tp SET tp.flag = 0 WHERE tp.pk = :pk";
        em.createQuery(SQL)
            .setParameter("pk", pk)
            .executeUpdate();
        em.clear();
    }

    @Override
    public int calcPercentageByNumAndPk(int pk) {
        final String SQL_DONE = "SELECT COUNT(tp.todonum) FROM todo_progress as tp WHERE tp.todonum=:pk AND tp.flag=1";
        final String SQL_ALL = "SELECT COUNT(tp.todonum) FROM todo_progress as tp WHERE tp.todonum=:pk";
        int done = (int)(long)em.createQuery(SQL_DONE).setParameter("pk", pk).getSingleResult();
        int all = (int)(long)em.createQuery(SQL_ALL).setParameter("pk", pk).getSingleResult();
        em.clear();
        return (int)(((double)done/all)*100);
    }
    @Override
    public int findByIdAndDate(int pk, String today){
        final String SQL="SELECT flag FROM todo_progress "+
        "WHERE todonum = :pk "+
        "AND dday = :today";
        int done = 0;
        try {
            done = (int)em.createNativeQuery(SQL)
            .setParameter("pk", pk)
            .setParameter("today", today)
            .getSingleResult();
        } catch (Exception e) {
            // System.out.println(e);
            done = -1;
        }finally{
            em.clear();
        }
        return done;
    }


    @Override
    public void insertTodoProgress(int todonum,List<String> dates){
        String sql = "INSERT INTO todo_progress(todonum, flag, dday) VALUES ";
        for (String date : dates) {
            sql+="(:todonum, 0, '"+date+"'), ";
        }
        sql = sql.substring(0, sql.length() - 2);
        em.createNativeQuery(sql)
            .setParameter("todonum", todonum)
            .executeUpdate();
        em.clear();
    }
}