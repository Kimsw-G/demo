package com.example.swtodo.repository_custom;

import java.util.List;



import com.example.swtodo.entity.EventEntity;

public interface EventCustomRepo {
    
    public List<EventEntity> findAllByDate(int user, String eday);
}
