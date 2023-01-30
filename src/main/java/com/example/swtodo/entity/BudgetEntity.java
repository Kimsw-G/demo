package com.example.swtodo.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BudgetEntity {
    private int pk;
    private Date startday;
    private int budget;
    private int changed;
    private int user;
}
