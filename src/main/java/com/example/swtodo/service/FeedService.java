package com.example.swtodo.service;

import java.util.List;

import com.example.swtodo.dto.FeedDTO;
import com.example.swtodo.entity.FeedEntity;
import com.example.swtodo.entity.SuserEntity;

public interface FeedService {
    
    public void addFeed(FeedEntity feedEntity);
    public void addEvent(FeedEntity feedEntity);
    public void addTodo(FeedEntity feedEntity);

    public void delFeed(FeedEntity feedEntity);
    public void delEvent(FeedEntity feedEntity);
    public void delTodo(FeedEntity feedEntity);

    public List<FeedEntity> getFeed(SuserEntity suserEntity, String date);
    public List<FeedEntity> getEvent(SuserEntity suserEntity, String date);
    public List<FeedDTO> getCurrentTodo(SuserEntity suserEntity);
    public List<FeedDTO> getExpiredTodo(SuserEntity suserEntity);
    public List<FeedDTO> getSpecDay(SuserEntity suserEntity, String date, String page);

    public void getEventThisMonth(SuserEntity suserEntity, String date);
    public void getTodoPercentThisDay(SuserEntity suserEntity, String date);
    public void getTodoPercentByNum();

    public void modFeed(FeedEntity feedEntity);
    public void modEvent(FeedEntity feedEntity);
    public void modTodo(FeedEntity feedEntity);
    
    public void doTodo(FeedEntity feedEntity);
    public void undoTodo(FeedEntity feedEntity);

}
