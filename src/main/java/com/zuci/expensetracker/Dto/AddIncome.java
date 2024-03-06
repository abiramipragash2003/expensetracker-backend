package com.zuci.expensetracker.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;


@Data

public class AddIncome
{

    private String username;
    private String type;
    private String incomeCategory;
    private String incomeName;
    private long cost;
    private long totalIncome;
    private LocalDate incomeDate;

}
