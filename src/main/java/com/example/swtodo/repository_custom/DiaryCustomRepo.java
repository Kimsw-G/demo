package com.example.swtodo.repository_custom;

import java.util.List;


import com.example.swtodo.entity.DiaryEntity;



public interface DiaryCustomRepo {

    List<DiaryEntity> findDiaryByUserAndDate(int user,String eday);
    
}
