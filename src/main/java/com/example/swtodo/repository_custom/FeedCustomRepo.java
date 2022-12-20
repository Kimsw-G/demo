package com.example.swtodo.repository_custom;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;

import com.example.swtodo.entity.FeedEntity;

public interface FeedCustomRepo {
    
    // 1. todo
    // 특정 유저의 모든 todo를 가져옴 (특정 달)
    List<FeedEntity> findTodoBySuser(int suser, String today);
    // 특정 유저의 '특정 날짜'의 할 일을 가져옴
    List<FeedEntity> findTodoToday(int suser, String today);
    // 특정 유저의 활성화된 할 일을 가져옴
    List<FeedEntity> findTodoCurrent(int suser, String today);
    // 특정 유저의 만료된 할 일을 가져옴
    List<FeedEntity> findTodoExpired(int suser, String today);

    // 2. event
    // 특정 유저의 모든 event를 가져옴 (특정 달)
    List<FeedEntity> findEventBySuser(int suser, String todoay);
    // 특정 유저의 '특정 날짜'의 이벤트를 가져옴
    List<FeedEntity> findEventToday(int suser, String today);
    // 이벤트를 저장
    @Transactional
    @Modifying
    void saveEvent(FeedEntity feedEntity);

    // 3. diary
    // 특정 유저의 일기를 가져옴
    List<FeedEntity> findDiaryToday(int suser,String today);
    // 일기 저장
    @Transactional
    @Modifying
    void saveDiary(FeedEntity feedEntity);

    // 4. budget

    // 5. all
    // 특정 유저의 '특정 날짜'의 모든 피드를 가져옴
    List<FeedEntity> findAllToday(int suser, String today, int page);
    
    
}
