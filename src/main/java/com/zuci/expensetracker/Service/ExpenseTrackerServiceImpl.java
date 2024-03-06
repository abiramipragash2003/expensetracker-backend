package com.zuci.expensetracker.Service;

import com.zuci.expensetracker.Dto.AddExpense;
import com.zuci.expensetracker.Dto.AddIncome;
import com.zuci.expensetracker.Model.ExpenseTracker;
import com.zuci.expensetracker.Repository.ExpenseTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseTrackerServiceImpl implements ExpenseTrackerService
{

    @Autowired
    ExpenseTrackerRepository expenseTrackerRepository;
    @Override
    public ExpenseTracker createExpense(AddExpense addExpense) {
        ExpenseTracker expenseTracker=new ExpenseTracker(addExpense.getUsername(),addExpense.getType(),addExpense.getExpenseCategory(), addExpense.getExpenseName(), addExpense.getCost(), addExpense.getExpenseDate());
        return expenseTrackerRepository.save(expenseTracker);
    }

    @Override
    public ExpenseTracker createIncome(AddIncome addIncome)
    {
        ExpenseTracker expenseTracker=new ExpenseTracker(addIncome.getUsername(), addIncome.getType(), addIncome.getIncomeCategory(), addIncome.getIncomeName(), addIncome.getCost(), addIncome.getIncomeDate());
        return expenseTrackerRepository.save(expenseTracker);
    }

    @Override
    public List<ExpenseTracker> getAllExpense()
    {
        return expenseTrackerRepository.findAll();
    }

    @Override
    public List<ExpenseTracker> getAllIncome() {
        return expenseTrackerRepository.findAll();
    }

    //@Override
//    public List<ExpenseTracker> getAllByDate(LocalDate expenseDate) {
//        return expenseTrackerRepository.findByDate(expenseDate);
//    }

}
