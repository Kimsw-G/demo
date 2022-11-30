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
@Entity(name="expenditure")
@Table(name="expenditure")
public class ExpeditureEntity {
    @Id
    @GeneratedValue
    private int pk;

    private int budgetnum;
    private String etext;
    private int ecost;
    private Date edate;
}
