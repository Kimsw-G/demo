package com.example.swtodo.dto;


import com.example.swtodo.entity.FeedEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FeedDTO{
    private int pk;
    private String start_day;
    private String end_day;
    private String ftitle;
    private String ftext;
    private int suser;
    private int ftype;

    private int percent;
    private int freq;
    private int done;

    public FeedEntity getFeedEntity(){
        FeedEntity feedEntity = new FeedEntity();
        feedEntity.setStart_day(this.start_day);
        feedEntity.setEnd_day(this.end_day);
        feedEntity.setFtitle(this.ftitle);
        feedEntity.setFtext(this.ftext);
        feedEntity.setSuser(this.suser);

        return feedEntity;
    }
    public void insertObject(FeedEntity feedEntity){
        this.pk = feedEntity.getPk();
        this.start_day = feedEntity.getStart_day();
        this.end_day = feedEntity.getEnd_day();
        this.ftitle = feedEntity.getFtitle();
        this.ftext = feedEntity.getFtext();
        this.suser = feedEntity.getSuser();
        this.ftype = feedEntity.getFtype();
    }
}
