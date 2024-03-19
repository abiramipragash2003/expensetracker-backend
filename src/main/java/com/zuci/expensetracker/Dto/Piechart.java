package com.zuci.expensetracker.Dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data

public class Piechart
{
    Map<String, Long> incomeMap = new HashMap<>();
    Map<String, Long> ExpenseMap = new HashMap<>();
}
