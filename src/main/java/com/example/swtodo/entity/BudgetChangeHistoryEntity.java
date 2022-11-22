package com.example.swtodo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="budget_change_history")
@Table(name="budget_change_history")
public class BudgetChangeHistoryEntity {
    @Id
    @GeneratedValue
    private int pk;

    private int budget_num;
    private Date chang_day;
    private String text;
    private int user;
}
