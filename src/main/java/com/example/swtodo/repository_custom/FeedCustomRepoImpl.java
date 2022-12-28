package com.example.swtodo.repository_custom;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.swtodo.entity.FeedEntity;

import java.util.List;

public class FeedCustomRepoImpl implements FeedCustomRepo {
    @Autowired
    EntityManager em;

    // 1. todo
    // 특정 유저의 모든 todo를 가져옴
    @Override
    public List<FeedEntity> findTodoBySuser(int suser, String today) {
        final String SQL = "SELECT f FROM feed AS f " +
        "WHERE f.suser = :suser " +
        "AND f.start_day BETWEEN :today AND LAST_DAY(:today) " +
        "AND f.end_day BETWEEN :today AND LAST_DAY(:today) " +
        "AND f.ftype=1";
        List<FeedEntity> result = em.createQuery(SQL, FeedEntity.class)
        .setParameter("suser", suser)
        .setParameter("today", today)
        .getResultList();
        em.clear();
        return result;
    }

    // 특정 유저의 '특정 날짜'의 할 일을 가져옴
    @Override
    public List<FeedEntity> findTodoToday(int suser, String today) {
        final String SQL = "SELECT f FROM feed AS f " +
        "WHERE f.suser = :suser " +
        "AND f.start_day BETWEEN :today AND LAST_DAY(:today) " +
        "AND f.ftype=1";
        List<FeedEntity> result = em.createQuery(SQL, FeedEntity.class)
        .setParameter("suser", suser)
        .setParameter("today", today)
        .getResultList();
        em.clear();
        return result;
    }

    // 특정 유저의 활성화된 할 일을 가져옴
    @Override
    public List<FeedEntity> findTodoCurrent(int suser, String today) {
        final String SQL = "SELECT f FROM feed AS f " +
        "WHERE f.suser=:suser " +
        "AND :today BETWEEN f.start_day AND f.end_day " +
        "AND f.ftype=1";
        List<FeedEntity> result = em.createQuery(SQL, FeedEntity.class)
        .setParameter("suser", suser)
        .setParameter("today", today)
        .getResultList();
        em.clear();
        return result;
    }

    // 특정 유저의 만료된 할 일을 가져옴
    @Override
    public List<FeedEntity> findTodoExpired(int suser, String today) {
        final String SQL = "SELECT f FROM feed AS f " +
        "WHERE f.suser=:suser " +
        "AND f.end_day < :today " +
        "AND f.ftype=1";
        List<FeedEntity> result = em.createQuery(SQL, FeedEntity.class)
        .setParameter("suser", suser)
        .setParameter("today", today)
        .getResultList();
        em.clear();
        return result;
    }

    // 2. event
    // 특정 유저의 모든 event를 가져옴 (특정 달)
    @Override
    public List<FeedEntity> findEventBySuser(int suser, String today) {
        final String SQL = "SELECT f.* FROM feed AS f " +
        "WHERE f.suser = :suser " +
        "AND :today BETWEEN f.start_day AND f.end_day " +
        "AND f.ftype=2";
        List<FeedEntity> result = em.createQuery(SQL, FeedEntity.class)
        .setParameter("suser", suser)
        .setParameter("today", today)
        .getResultList();
        em.clear();
        return result;

    }

    // 특정 유저의 '특정 날짜'의 이벤트를 가져옴
    @Override
    public List<FeedEntity> findEventToday(int suser, String today) {
        final String SQL = "SELECT f.* FROM feed AS f " +
        "WHERE f.suser = :suser " +
        "AND f.start_day = :tdoay " +
        "AND f.ftype=2";
        List<FeedEntity> result = em.createQuery(SQL, FeedEntity.class)
        .setParameter("suser", suser)
        .setParameter("today", today)
        .getResultList();
        em.clear();
        return result;
    }

    // 이벤트를 저장
    @Override
    public void saveEvent(FeedEntity feedEntity) {
        String sql = "INSERT INTO feed(start_day, ftitle, ftext, suser, ftype, freq) VALUES " +
        "(:start_day, :ftitle, :ftext, :suser, 2, :freq)";

        System.out.println(sql);
        em.createNativeQuery(sql)
        .setParameter("start_day", feedEntity.getStart_day())
        .setParameter("ftitle", feedEntity.getFtitle())
        .setParameter("ftext", feedEntity.getFtext())
        .setParameter("suser", feedEntity.getSuser())
        .setParameter("freq", feedEntity.getFreq())
        .executeUpdate();
        em.clear();
    }

    // 3. diary
    // 특정 유저의 일기를 가져옴
    @Override
    public List<FeedEntity> findDiaryToday(int suser, String today) {
        final String SQL = "SELECT f.* FROM feed AS f " +
        "WHERE f.suser = :suser " +
        "AND f.start_day = :tdoay " +
        "AND f.ftype=3";
        List<FeedEntity> result = em.createQuery(SQL, FeedEntity.class)
        .setParameter("suser", suser)
        .setParameter("today", today)
        .getResultList();
        return result;
    }

    // 일기 저장
    @Override
    public void saveDiary(FeedEntity feedEntity) {
        String sql = "INSERT INTO feed(start_day, ftitle, ftext, suser, ftype) VALUES " +
        "(:start_day, :ftitle, :ftext, :suser, 3)";

        System.out.println(sql);
        em.createNativeQuery(sql)
        .setParameter("start_day", feedEntity.getStart_day())
        .setParameter("ftitle", feedEntity.getFtitle())
        .setParameter("ftext", feedEntity.getFtext())
        .setParameter("suser", feedEntity.getSuser())
        .executeUpdate();
        em.clear();
    }

    // 4. budget

    // 5. all
    // 특정 유저의 '특정 날짜'의 모든 피드를 가져옴. 10개씩 가져옴
    @Override
    public List<FeedEntity> findAllToday(int suser, String today, int page) {
        final String SQL = "SELECT * FROM feed AS f "+
        "WHERE f.suser=:suser " +
        "AND :today BETWEEN f.start_day AND f.end_day "+
        "ORDER BY f.ftype ";
        List<FeedEntity> result = em.createNativeQuery(SQL, FeedEntity.class)
        .setParameter("suser", suser)
        .setParameter("today",today)
        .setFirstResult((page-1)*10)
        .setMaxResults(10)
        .getResultList();

        // for (FeedEntity feedEntity : result) {
        //     System.out.println(feedEntity);
        // }

        em.clear();
        
        return result;

    }

}
