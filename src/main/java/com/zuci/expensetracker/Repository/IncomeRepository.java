package com.zuci.expensetracker.Repository;

import com.zuci.expensetracker.Model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income,String> {

}
