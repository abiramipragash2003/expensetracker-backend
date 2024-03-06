package com.zuci.expensetracker.Controller;
import com.zuci.expensetracker.Dto.AddExpense;
import com.zuci.expensetracker.Dto.AddIncome;
import com.zuci.expensetracker.Model.ExpenseTracker;
import com.zuci.expensetracker.Service.ExpenseTrackerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping(value = "/expensetracker")
@RestController

public class ExpenseTrackerController
{
    @Autowired
    ExpenseTrackerServiceImpl expenseService;
    @PostMapping(value="/expense")
    public ExpenseTracker createExpense(@RequestBody AddExpense addExpense)
    {
        return expenseService.createExpense(addExpense);
    }
    @PostMapping(value="/income")
    public ExpenseTracker createIncome(@RequestBody AddIncome addIncome)
    {
        return expenseService.createIncome(addIncome);
    }
    @GetMapping(value = "/expense")
    public List<ExpenseTracker> getAllExpense()
    {
        return expenseService.getAllExpense();
    }
    @GetMapping(value = "/income")
    public List<ExpenseTracker> getAllIncome()
    {
        return expenseService.getAllIncome();
    }
//    @GetMapping(value="/expense/{expenseDate}")
//    public List<ExpenseTracker> getExpenseByDate(@PathVariable LocalDate expenseDate)
//    {
//        return expenseService.getAllByDate(expenseDate);
//    }
    //@GetMapping (value="/expense/{expenseDate}")


    
}
