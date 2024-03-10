package com.zuci.expensetracker.Service;

import com.zuci.expensetracker.Dto.AddExpense;
import com.zuci.expensetracker.Dto.AddIncome;
import com.zuci.expensetracker.Dto.Response;
import com.zuci.expensetracker.Exception.IdNotFoundException;
import com.zuci.expensetracker.Exception.NullException;
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
        ExpenseTracker expenseTracker=new ExpenseTracker(addExpense.getUserName(),addExpense.getType(),addExpense.getExpenseCategory(), addExpense.getExpenseName(), addExpense.getCost(), addExpense.getExpenseDate());
        return expenseTrackerRepository.save(expenseTracker);
    }

    @Override
    public ExpenseTracker createIncome(AddIncome addIncome)
    {
        ExpenseTracker expenseTracker=new ExpenseTracker(addIncome.getUserName(), addIncome.getType(), addIncome.getIncomeCategory(), addIncome.getIncomeName(), addIncome.getCost(), addIncome.getIncomeDate());
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
    public Response getAllByDate(LocalDate date)
    {
        long totalIncome=0,totalExpense=0;
        Response response=new Response();
        List<ExpenseTracker> expenseTrackerList=expenseTrackerRepository.findAllByDate(date);
        if(!expenseTrackerList.isEmpty())//list is not empty
        {
            response.setExpenseTracker(expenseTrackerList);
            try
            {
                totalExpense = expenseTrackerRepository.total(date, "expense");
            }
            catch (Exception e)
            {
                throw new NullException();
            }
            try
            {
                totalIncome = expenseTrackerRepository.total(date, "income");
            }
            catch (Exception e)
            {
                throw new NullException();
            }
            long balance = totalIncome - totalExpense;
            response.setTotalExpense(totalExpense);
            response.setTotalIncome(totalIncome);
            response.setBalance(balance);
        }
        else
        {
            response.setMessage("no transaction");
        }
        return response;

    }

    @Override
    public Response getAllByMonthAndYear(LocalDate monthAndYear)
    {
        long totalIncome=0,totalExpense=0;
        int year= monthAndYear.getYear();
        int month=monthAndYear.getMonthValue();
        Response response=new Response();
        List<ExpenseTracker> expenseTrackerList=expenseTrackerRepository.findAllByMonthAndYear(year,month);
        if(!expenseTrackerList.isEmpty())//list is not empty
        {
            response.setExpenseTracker(expenseTrackerList);
            try
            {
                totalExpense = expenseTrackerRepository.total(year, month,"expense");
            }
            catch (Exception e)
            {
                //throw new NullException();
            }
            try
            {
                totalIncome = expenseTrackerRepository.total(year, month, "income");
            }
            catch (Exception e)
            {
                //throw new NullException();
            }
            long balance = totalIncome - totalExpense;
            response.setTotalExpense(totalExpense);
            response.setTotalIncome(totalIncome);
            response.setBalance(balance);
        }
        else
        {
            response.setMessage("no transaction");
        }
        return response;




//        long totalExpense=expenseTrackerRepository.total(monthAndYear,"expense");
//        long totalIncome=expenseTrackerRepository.total(monthAndYear,"income");
//        long balance=totalIncome-totalExpense;
//        response.setTotalExpense(totalExpense);
//        response.setTotalIncome(totalIncome);
//        response.setBalance(balance);


    }

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

    @Override
    public long getCostByTypeCategory(String type, String category) {
        return expenseTrackerRepository.findCostByTypeCategory(type,category);
    }


}
