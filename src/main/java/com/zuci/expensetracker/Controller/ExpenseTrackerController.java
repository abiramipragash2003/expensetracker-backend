package com.zuci.expensetracker.Controller;

import com.zuci.expensetracker.Dto.AddExpense;
import com.zuci.expensetracker.Dto.AddIncome;
import com.zuci.expensetracker.Dto.Piechart;
import com.zuci.expensetracker.Dto.Response;
import com.zuci.expensetracker.Model.ExpenseTracker;
import com.zuci.expensetracker.Service.ExpenseTrackerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RequestMapping(value = "/expensetracker")
@RestController

public class ExpenseTrackerController {
    @Autowired
    ExpenseTrackerServiceImpl expenseTrackerService;

    @PostMapping(value = "/expense")
    public ExpenseTracker createExpense(@Valid @RequestBody AddExpense addExpense) {
        return expenseTrackerService.createExpense(addExpense);
    }

    @PostMapping(value = "/income")
    public ExpenseTracker createIncome(@Valid @RequestBody AddIncome addIncome) {
        return expenseTrackerService.createIncome(addIncome);
    }

    @GetMapping(value = "/type/{type}")
    public Piechart getAllByType(@PathVariable String type) {
        return expenseTrackerService.getAllByType(type);
    }
    @GetMapping(value = "/{type}/{category}")
    public long getCostByTypeCategory(@PathVariable String type, @PathVariable String category) {
        return expenseTrackerService.getCostByTypeCategory(type, category);
    }

    @GetMapping(value = "/date/{date}")
    public Response getAllByDate(@PathVariable LocalDate date) {
        return expenseTrackerService.getAllByDate(date);
    }

    @GetMapping(value = "/month/{monthAndYear}")
    public Response getAllByMonthAndYear(@PathVariable LocalDate monthAndYear) {
        return expenseTrackerService.getAllByMonthAndYear(monthAndYear);
    }

    @GetMapping(value = "/year/{inputyear}")
    public Response getAllByYear(@PathVariable LocalDate inputyear) {
        return expenseTrackerService.getAllByYear(inputyear);
    }


    @PutMapping(value = "/{id}")
    public ExpenseTracker updateById(@PathVariable long id, @RequestBody ExpenseTracker expenseTracker) {
        return expenseTrackerService.updateById(id, expenseTracker);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteById(@PathVariable long id) {
        return expenseTrackerService.deleteById(id);
    }


}
