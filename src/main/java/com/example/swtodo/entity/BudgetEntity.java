package com.example.swtodo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "budget")
@Table(name = "budget")
public class BudgetEntity {
    @Id
    private int pk;

    private Date startday;
    private int budget;
    private int changed;
    private int suser;
}
