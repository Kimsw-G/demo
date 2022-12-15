package com.example.swtodo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "budget")
@Table(name = "budget")
public class BudgetEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int pk;

    private String startday;
    private int budget;
    private int changed;
    private int suser;
}
