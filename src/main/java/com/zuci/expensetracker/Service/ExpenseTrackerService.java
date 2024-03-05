package com.zuci.expensetracker.Service;

import com.zuci.expensetracker.Model.Expense;
import com.zuci.expensetracker.Model.Income;

public interface ExpenseTrackerService {
    public Expense createExpense(Expense expense);
    public Income createIncome(Income income);
}
