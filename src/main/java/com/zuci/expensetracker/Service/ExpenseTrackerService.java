package com.zuci.expensetracker.Service;

import com.zuci.expensetracker.Dto.AddExpense;
import com.zuci.expensetracker.Dto.AddIncome;
import com.zuci.expensetracker.Model.ExpenseTracker;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseTrackerService {
    public ExpenseTracker createExpense(AddExpense addExpense);
    public ExpenseTracker createIncome(AddIncome addIncome);
    public List<ExpenseTracker> getAllByType(String type);

    public String deleteById(long id);

    List<ExpenseTracker> getAllByDate(LocalDate date);
    //List<ExpenseTracker> getAllByMonthAndYear(LocalDate monthAndYear);

    public ExpenseTracker updateById(long id, ExpenseTracker expenseTracker);
}
