package com.zuci.expensetracker.Service;

import com.zuci.expensetracker.Dto.AddExpense;
import com.zuci.expensetracker.Dto.AddIncome;
import com.zuci.expensetracker.Dto.Response;
import com.zuci.expensetracker.Model.ExpenseTracker;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseTrackerService {
    public ExpenseTracker createExpense(AddExpense addExpense);

    public ExpenseTracker createIncome(AddIncome addIncome);

    public List<ExpenseTracker> getAllByType(String type);

    public String deleteById(long id);

    Response getAllByDate(LocalDate date);

    Response getAllByMonthAndYear(LocalDate monthAndYear);

    Response getAllByYear(LocalDate inputyear);

    public ExpenseTracker updateById(long id, ExpenseTracker expenseTracker);

    long getCostByTypeCategory(String type, String category);


}
