package com.zuci.expensetracker.Controller;
import com.zuci.expensetracker.Model.Expense;
import com.zuci.expensetracker.Model.Income;
import com.zuci.expensetracker.Service.ExpenseTrackerServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping(value = "/expensetracker")
@RestController

public class ExpenseTrackerController
{
    @Autowired
    ExpenseTrackerServiceImpl expenseService;
    @PostMapping(value="/expense")
    public Expense createExpense(@RequestBody Expense expense, HttpServletRequest request)
    {
        return expenseService.createExpense(expense);
    }
    @PostMapping(value="/income")
    public Income createIncome(@RequestBody Income income)
    {
        return expenseService.createIncome(income);
    }
    @GetMapping(value = "/expense")
    public List<Expense> getAllExpense()
    {
        return expenseService.getAllExpense();
    }
    @GetMapping(value = "/income")
    public List<Income> getAllIncome()
    {
        return expenseService.getAllIncome();
    }
    @GetMapping(value="/expense/{expenseDate}")
    public List<Expense> getExpenseByExpensetype(@PathVariable String expenseDate)
    {
        return expenseService.getExpenseByDate(expenseType);
    }
    
}
