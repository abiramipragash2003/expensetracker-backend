package com.zuci.expensetracker.Repository;

import com.zuci.expensetracker.Model.ExpenseTracker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseTrackerRepository extends JpaRepository<ExpenseTracker,Long> {

    //List<ExpenseTracker> findByDate(LocalDate expenseDate);
}
