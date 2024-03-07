package com.zuci.expensetracker.Service;

import com.zuci.expensetracker.Dto.AddExpense;
import com.zuci.expensetracker.Dto.AddIncome;
import com.zuci.expensetracker.Exception.IdNotFoundException;
import com.zuci.expensetracker.Model.ExpenseTracker;
import com.zuci.expensetracker.Repository.ExpenseTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public List<ExpenseTracker> getAllByType(String type)
    {
        return expenseTrackerRepository.findAllByType(type);
    }

    @Override
    public String deleteById(long id)
    {
        String status=null;
        Optional<ExpenseTracker> optional=expenseTrackerRepository.findById(id);
        if(optional.isPresent())
        {
            expenseTrackerRepository.deleteById(id);
            status="deleted successfully";

        }
        else
        {

            throw new IdNotFoundException();

        }
        return status;

    }

    @Override
    public List<ExpenseTracker> getAllByDate(LocalDate date)
    {
        return expenseTrackerRepository.findAllByDate(date);
    }

//    @Override
//    public List<ExpenseTracker> getAllByMonthAndYear(LocalDate monthAndYear)
//    {
//        int year= monthAndYear.getYear();
//        int month=monthAndYear.getMonthValue();
//        return expenseTrackerRepository.findAllByMonthAndYear(year,month);
//    }

    @Override
    public ExpenseTracker updateById(long id, ExpenseTracker expenseTracker) {
        ExpenseTracker expenseTracker1=expenseTrackerRepository.findById(id).get();
        if(expenseTracker.getCategory()!=null)
        {
            expenseTracker1.setCategory(expenseTracker.getCategory());
        }
        if(expenseTracker.getCost()!=0)
        {
            expenseTracker1.setCost(expenseTracker.getCost());
        }
        if(expenseTracker.getName()!=null)
        {
            expenseTracker1.setName(expenseTracker.getName());
        }
        return expenseTrackerRepository.save(expenseTracker1);
    }


}
