package com.zuci.expensetracker.Controller;
import com.zuci.expensetracker.Model.Expense;
import com.zuci.expensetracker.Model.Income;
import com.zuci.expensetracker.Service.ExpenseTrackerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/expensetracker")
@RestController

public class ExpenseTrackerController
{
    @Autowired
    ExpenseTrackerServiceImpl expenseService;
    @PostMapping(value="/expense")
    public Expense createExpense(@RequestBody Expense expense)
    {
        return expenseService.createExpense(expense);
    }
    @PostMapping(value="/income")
    public Income createIncome(@RequestBody Income income)
    {
        return expenseService.createIncome(income);
    }
    
}
