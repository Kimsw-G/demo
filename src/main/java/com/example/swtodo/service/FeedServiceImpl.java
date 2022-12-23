package com.example.swtodo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swtodo.dto.FeedDTO;
import com.example.swtodo.entity.FeedEntity;
import com.example.swtodo.entity.SuserEntity;
import com.example.swtodo.repository.TodoProgressRepo;
import com.example.swtodo.repository.FeedRepo;
import com.example.swtodo.share.DateConfigure;



@Service

public class FeedServiceImpl implements FeedService {

    @Autowired
    FeedRepo feedRepo;
    @Autowired
    TodoProgressRepo todoProgressRepo;
    @Autowired
    DateConfigure dateConfigure;

    @Override
    public void addDiary(FeedEntity feedEntity) {
        feedRepo.saveDiary(feedEntity);
    }

    @Override
    public void addEvent(FeedEntity feedEntity) {
        feedRepo.saveEvent(feedEntity);
    }

    @Override
    public void addTodo(FeedDTO todoDTO) {
        int pk = feedRepo.save(todoDTO.getFeedEntity()).getPk();
        List<String> dates = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar startDay = Calendar.getInstance();
        Calendar endDay = Calendar.getInstance();
        try {
            startDay.setTime(sdf.parse(todoDTO.getStart_day()));
            endDay.setTime(sdf.parse(todoDTO.getEnd_day()));
        } catch (Exception e) {}
        boolean[] isDows = dateConfigure.getIsDows(todoDTO.getFreq());
        int dif = dateConfigure.getDayDiff(endDay, startDay);
        System.out.println(dif);
        for (int i = 0; i < dif; i++) {
            System.out.println("####");
            System.out.println(startDay.get(Calendar.DAY_OF_WEEK));
            System.out.println(startDay.get(Calendar.DAY_OF_MONTH));
            System.out.println(isDows[startDay.get(Calendar.DAY_OF_WEEK)-1]);
            if(isDows[startDay.get(Calendar.DAY_OF_WEEK)-1]){
                // 요일이 해당
                // 로직 수행 필요
                dates.add(sdf.format(startDay.getTime()));
            }
            // 연산 수행 후 1 추가
            startDay.add(Calendar.DATE, 1);
        }
        for (String date : dates) {
            System.out.println(date);
        }
        if(dates.size()!=0){
            
            todoProgressRepo.insertTodoProgress(pk, dates);
        }


    }

    @Override
    public void delEvent(FeedEntity feedEntity) {
    }

    @Override
    public void delTodo(FeedEntity feedEntity) {
    }

    @Override
    public void delDiary(FeedEntity feedEntity) {
    }

    @Override
    public List<FeedEntity> getDiary(SuserEntity userEntity, String date) {
        // Diary를 특정 유저의 특정 기간만 가져오는 쿼리
        return feedRepo.findDiaryToday(userEntity.getPk(), date);

    }

    @Override
    public List<FeedEntity> getEvent(SuserEntity userEntity, String date) {

        return feedRepo.findEventBySuser(0, date);

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
            }
            resultList.add(feedDTO);
        }
        return resultList;
    }

    

    @Override
    public void getEventThisMonth(SuserEntity userEntity, String date) {
        feedRepo.findEventBySuser(userEntity.getPk(), date);

    }

    @Override
    public void getTodoPercentThisDay(SuserEntity userEntity, String date) {

    }

    @Override
    public void getTodoPercentByNum() {

    }

    @Override
    public void modDiary(FeedEntity diaryEntity) {
        feedRepo.save(diaryEntity);
    }

    @Override
    public void modEvent(FeedEntity eventEntity) {
        feedRepo.save(eventEntity);
    }

    @Override
    public void modTodo(FeedEntity todoEntity) {
        feedRepo.save(todoEntity);
    }

    @Override
    public void doTodo(FeedEntity todoEntity) {
        todoProgressRepo.doCheck(todoEntity.getPk());
    }

    @Override
    public void undoTodo(FeedEntity todoEntity) {
        todoProgressRepo.undoCheck(todoEntity.getPk());
    }

}
