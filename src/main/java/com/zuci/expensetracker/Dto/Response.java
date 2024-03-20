package com.zuci.expensetracker.Dto;

import com.zuci.expensetracker.Model.ExpenseTracker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Response {

    private List<ExpenseTracker> expenseTracker;

    private long totalExpense;

    private long totalIncome;

    private long balance;

    Map<String, Long> incomeMap = new HashMap<>();

    Map<String, Long> ExpenseMap = new HashMap<>();

}
