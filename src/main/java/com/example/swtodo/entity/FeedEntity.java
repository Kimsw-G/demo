package com.example.swtodo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name="feed")
@Table(name="feed")
public class FeedEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int pk;

    private String start_day;
    private String end_day;
    private String ftitle;
    private String ftext;
    private int suser;
    private int ftype;
    private int freq;
}
