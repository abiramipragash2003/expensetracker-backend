package com.zuci.expensetracker.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data

public class AddExpense
{

    private String username;
    private String type;
    private String expenseCategory;
    private String expenseName;
    private long cost;
    private LocalDate expenseDate;
    private long totalExpense;

}
