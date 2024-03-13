package com.zuci.expensetracker.Repository;

import com.zuci.expensetracker.Model.ExpenseTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ExpenseTracker, Long> {

}
