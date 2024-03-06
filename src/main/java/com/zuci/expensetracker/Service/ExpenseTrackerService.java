package com.zuci.expensetracker.Service;

import com.zuci.expensetracker.Model.Expense;
import com.zuci.expensetracker.Model.Income;

import java.util.Date;
import java.util.List;

public interface ExpenseTrackerService {
    public Expense createExpense(Expense expense);
    public Income createIncome(Income income);
    public List<Expense> getAllExpense();

    List<Income> getAllIncome();

    List<Expense> getExpenseByDate(String expenseCategory);
}
