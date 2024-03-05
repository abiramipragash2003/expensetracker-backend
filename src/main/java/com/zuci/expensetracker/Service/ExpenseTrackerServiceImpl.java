package com.zuci.expensetracker.Service;

import com.zuci.expensetracker.Model.Expense;
import com.zuci.expensetracker.Model.Income;
import com.zuci.expensetracker.Repository.ExpenseRepository;
import com.zuci.expensetracker.Repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseTrackerServiceImpl implements ExpenseTrackerService
{
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    IncomeRepository incomeRepository;
    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }
}
