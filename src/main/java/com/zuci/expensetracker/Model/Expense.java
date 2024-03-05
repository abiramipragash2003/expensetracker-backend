package com.zuci.expensetracker.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Expense
{
    @Id
    private String username;
    private String expenseCategory;
    private String expenseName;
    private long cost;
    private Date expenseDate;
    private long totalexpense;
}
