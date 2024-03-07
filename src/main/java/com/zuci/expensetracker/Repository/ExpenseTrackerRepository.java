package com.zuci.expensetracker.Repository;

import com.zuci.expensetracker.Model.ExpenseTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseTrackerRepository extends JpaRepository<ExpenseTracker,Long> {

    List<ExpenseTracker> findAllByDate(LocalDate expenseDate);

    List<ExpenseTracker> findAllByType(String type);
//    @Query("SELECT e FROM ExpenseTracker e WHERE YEAR(e.date) = :year AND MONTH(e.date) = :month")
//    List<ExpenseTracker> findAllByMonthAndYear(@Param("year") int year, @Param("month") int month);

}
