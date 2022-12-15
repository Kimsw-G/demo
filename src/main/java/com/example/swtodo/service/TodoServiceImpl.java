package com.example.swtodo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swtodo.dto.SeeTodoDTO;
import com.example.swtodo.dto.TodoDTO;
import com.example.swtodo.entity.DiaryEntity;
import com.example.swtodo.entity.EventEntity;
import com.example.swtodo.entity.TodoEntity;
import com.example.swtodo.entity.SuserEntity;
import com.example.swtodo.repository.DiaryRepo;
import com.example.swtodo.repository.EventRepo;
import com.example.swtodo.repository.TodoProgressRepo;
import com.example.swtodo.repository.TodoRepo;
import com.example.swtodo.share.DateConfigure;

import ch.qos.logback.classic.net.SyslogAppender;

@Service

public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepo todoRepo;
    // @Autowired
    DiaryRepo diaryRepo;
    @Autowired
    EventRepo eventRepo;
    @Autowired
    TodoProgressRepo todoProgressRepo;
    @Autowired
    DateConfigure dateConfigure;

    @Override
    public void writeDiary(DiaryEntity diaryEntity) {
        diaryRepo.save(diaryEntity);
    }

    @Override
    public void addEvent(EventEntity eventEntity) {
        eventRepo.save(eventEntity);
    }

    @Override
    public void addTodo(TodoDTO todoDTO) {
        int pk = todoRepo.save(todoDTO.getTodoEntity()).getPk();
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
    public void delEvent(EventEntity eventEntity) {
        eventRepo.delete(eventEntity);
    }

    @Override
    public void delTodo(TodoEntity todoEntity) {
        todoRepo.delete(todoEntity);
    }

    @Override
    public void delDiary(DiaryEntity diaryEntity) {
        diaryRepo.delete(diaryEntity);
    }

    @Override
    public List<DiaryEntity> getDiary(SuserEntity userEntity, String date) {
        // Diary를 특정 유저의 특정 기간만 가져오는 쿼리
        return diaryRepo.findDiaryByUserAndDate(userEntity.getPk(), date);

    }

    @Override
    public List<EventEntity> getEvent(SuserEntity userEntity, String date) {
        // 특정 Diary를 특정 유저 및 특정 기간만 가져오는 쿼리

        return eventRepo.findAllByDate(userEntity.getPk(), date);

    }

    @Override
    public List<SeeTodoDTO> getCurrentTodo(SuserEntity userEntity) {
        List<TodoEntity> sqlList = todoRepo.findAllCurrentTodo(userEntity.getPk(), dateConfigure.getToday());
        List<SeeTodoDTO> resultList = new ArrayList<>();
        for (TodoEntity todoEntity : sqlList) {
            SeeTodoDTO seeTodoDTO = new SeeTodoDTO();
            seeTodoDTO.insertObject(todoEntity);
            seeTodoDTO.setPercent(todoProgressRepo.calcPercentageByNumAndPk(seeTodoDTO.getPk()));
            resultList.add(seeTodoDTO);
        }
        return resultList;
    }

    public List<SeeTodoDTO> getExpiredTodo(SuserEntity userEntity) {
        List<TodoEntity> sqlList = todoRepo.findAllExpiredTodo(userEntity.getPk(), dateConfigure.getToday());
        List<SeeTodoDTO> resultList = new ArrayList<>();
        for (TodoEntity todoEntity : sqlList) {
            SeeTodoDTO seeTodoDTO = new SeeTodoDTO();
            seeTodoDTO.insertObject(todoEntity);
            seeTodoDTO.setPercent(todoProgressRepo.calcPercentageByNumAndPk(seeTodoDTO.getPk()));
            resultList.add(seeTodoDTO);
        }
        return resultList;
    }

    @Override
    public void getEventThisMonth(SuserEntity userEntity, String date) {
        eventRepo.findAllByDate(userEntity.getPk(), date);

    }

    @Override
    public void getTodoPercentThisDay(SuserEntity userEntity, String date) {

    }

    @Override
    public void getTodoPercentByNum() {

    }

    @Override
    public void modDiary(DiaryEntity diaryEntity) {
        diaryRepo.save(diaryEntity);
    }

    @Override
    public void modEvent(EventEntity eventEntity) {
        eventRepo.save(eventEntity);
    }

    @Override
    public void modTodo(TodoEntity todoEntity) {
        todoRepo.save(todoEntity);
    }

    @Override
    public void doTodo(TodoEntity todoEntity) {
        todoProgressRepo.doCheck(todoEntity.getPk());
    }

    @Override
    public void undoTodo(TodoEntity todoEntity) {
        todoProgressRepo.undoCheck(todoEntity.getPk());
    }

}
