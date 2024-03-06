package com.zuci.expensetracker.Repository;

import com.zuci.expensetracker.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,String> {
    //findby expenseDate ---> select * from expense where expenseDate=expenseDate
    List<Expense> findByExpenseDate(Date expenseDate);

    List<Expense> findByExpenseCategory(String expenseCategory);
}
