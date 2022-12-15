package com.example.swtodo.repository_custom;

import java.util.List;

import javax.persistence.EntityManager;

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
    public void insertTodoProgress(int todonum,List<String> dates){
        String sql = "INSERT INTO todo_progress(todonum, flag, dday) VALUES ";
        for (String date : dates) {
            sql+="(:todonum, 0, '"+date+"'), ";
        }
        sql = sql.substring(0, sql.length() - 2);
        System.out.println(sql);
        em.createNativeQuery(sql)
            .setParameter("todonum", todonum)
            .executeUpdate();
        em.clear();
    }
}
