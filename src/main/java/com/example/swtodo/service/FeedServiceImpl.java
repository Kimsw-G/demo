package com.example.swtodo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swtodo.dto.FeedDTO;
import com.example.swtodo.entity.FeedEntity;
import com.example.swtodo.entity.SuserEntity;
import com.example.swtodo.entity.TodoProgressEntity;
import com.example.swtodo.repository.FeedRepo;
import com.example.swtodo.repository.TodoProgressRepo;
import com.example.swtodo.share.DateConfigure;

@Service
public class FeedServiceImpl implements FeedService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FeedRepo feedRepo;
    @Autowired 
    TodoProgressRepo todoProgressRepo;
    @Autowired
    DateConfigure dateConfigure;
    
    @Override
    public void addFeed(FeedEntity feedEntity) {
        logger.info("add feed");
        feedRepo.saveFeed(feedEntity);
    }

    @Override
    public void addEvent(FeedEntity feedEntity) {
        logger.info("add event");
        feedRepo.saveEvent(feedEntity);        
    }

    @Override
    public void addTodo(FeedEntity feedEntity) {
        int pk = feedRepo.save(feedEntity).getPk();
        List<String> dates = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        Calendar startDay = Calendar.getInstance();
        Calendar endDay = Calendar.getInstance();
        try{
            startDay.setTime(sdf.parse(feedEntity.getStart_day()));
            endDay.setTime(sdf.parse(feedEntity.getEnd_day()));
        }catch(Exception e){}
        boolean[] isDows = dateConfigure.getIsDows(feedEntity.getFreq());
        int dif = dateConfigure.getDayDiff(endDay, startDay);
        for (int i = 0; i < dif+1; i++) {
            // System.out.println("####");
            // System.out.println(startDay.get(Calendar.DAY_OF_WEEK));
            // System.out.println(startDay.get(Calendar.DAY_OF_MONTH));
            // System.out.println(isDows[startDay.get(Calendar.DAY_OF_WEEK)-1]);
            if(isDows[startDay.get(Calendar.DAY_OF_WEEK)-1]){
                dates.add(sdf.format(startDay.getTime()));
            }
            // 연산 수행 후 1 추가
            startDay.add(Calendar.DATE, 1);
        }
        // for (String date : dates) {
        //     System.out.print(date);
        // }
        if(dates.size()!=0){ 
            todoProgressRepo.insertTodoProgress(pk, dates);
        }
    }

    @Override
    public void delFeed(FeedEntity feedEntity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delEvent(FeedEntity feedEntity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delTodo(FeedEntity feedEntity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<FeedEntity> getFeed(SuserEntity suserEntity, String date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FeedEntity> getEvent(SuserEntity suserEntity, String date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FeedDTO> getCurrentTodo(SuserEntity userEntity) {
        List<FeedEntity> sqlList = feedRepo.findTodoCurrent(userEntity.getPk(), dateConfigure.getToday());
        List<FeedDTO> resultList = new ArrayList<>();
        for (FeedEntity todoEntity : sqlList) {
            FeedDTO feedDTO = new FeedDTO();
            feedDTO.insertObject(todoEntity);
            feedDTO.setPercent(todoProgressRepo.calcPercentageByNumAndPk(feedDTO.getPk()));
            resultList.add(feedDTO);
        }
        return resultList;
    }

    @Override
    public List<FeedDTO> getExpiredTodo(SuserEntity userEntity) {
        List<FeedEntity> sqlList = feedRepo.findTodoExpired(userEntity.getPk(), dateConfigure.getToday());
        List<FeedDTO> resultList = new ArrayList<>();
        for (FeedEntity todoEntity : sqlList) {
            FeedDTO feedDTO = new FeedDTO();
            feedDTO.insertObject(todoEntity);
            feedDTO.setPercent(todoProgressRepo.calcPercentageByNumAndPk(feedDTO.getPk()));
            resultList.add(feedDTO);
        }
        return resultList;
    }

    @Override
    public List<FeedDTO> getSpecDay(SuserEntity userEntity,String date, String page){
        List<FeedEntity> feedList = feedRepo.findAllToday(userEntity.getPk(), date, Integer.parseInt(page));
        List<FeedDTO> resultList = new ArrayList<FeedDTO>();
        for (FeedEntity feedEntity : feedList) {
            FeedDTO feedDTO = new FeedDTO();
            feedDTO.insertObject(feedEntity);
            if(feedDTO.getFtype()==1){ // ftype이 todo이면 calc를 계산한다
                feedDTO.setPercent(todoProgressRepo.calcPercentageByNumAndPk(feedDTO.getPk()));
                feedDTO.setDone(todoProgressRepo.findByIdAndDate(feedDTO.getPk(),date));
            }
            resultList.add(feedDTO);
        }
        return resultList;
    }

    @Override
    public void getEventThisMonth(SuserEntity suserEntity, String date) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getTodoPercentThisDay(SuserEntity suserEntity, String date) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getTodoPercentByNum() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void modFeed(FeedEntity feedEntity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void modEvent(FeedEntity feedEntity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void modTodo(FeedEntity feedEntity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doTodo(TodoProgressEntity todoProgressEntity) {
        todoProgressRepo.doCheck(todoProgressEntity.getPk(),todoProgressEntity.getDday());
        
    }

    @Override
    public void undoTodo(TodoProgressEntity todoProgressEntity) {
        todoProgressRepo.undoCheck(todoProgressEntity.getPk(),todoProgressEntity.getDday());
        
    }

    
    
    
    
}
