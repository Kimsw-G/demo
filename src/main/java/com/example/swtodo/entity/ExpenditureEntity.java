package com.example.swtodo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="expenditure")
@Table(name="expenditure")
public class ExpenditureEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int pk;

    private int budgetnum;
    private String etext;
    private int ecost;
    private String edate;
}
