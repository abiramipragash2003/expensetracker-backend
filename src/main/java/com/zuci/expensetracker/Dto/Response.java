package com.zuci.expensetracker.Dto;

import com.zuci.expensetracker.Model.ExpenseTracker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Response {
    private List<ExpenseTracker> expenseTracker;

    private long totalExpense;

    private long totalIncome;

    private long balance;

}
