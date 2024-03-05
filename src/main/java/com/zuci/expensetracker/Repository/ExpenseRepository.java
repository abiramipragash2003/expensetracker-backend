package com.zuci.expensetracker.Repository;

import com.zuci.expensetracker.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,String> {
}
