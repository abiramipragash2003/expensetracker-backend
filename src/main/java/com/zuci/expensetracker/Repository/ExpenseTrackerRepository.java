package com.zuci.expensetracker.Repository;

import com.zuci.expensetracker.Model.ExpenseTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseTrackerRepository extends JpaRepository<ExpenseTracker, Long> {

    List<ExpenseTracker> findAllByType(String type);

    List<ExpenseTracker> findAllByDate(LocalDate expenseDate);

    @Query("SELECT SUM(e.cost) FROM ExpenseTracker e WHERE e.date = :date AND e.type= :type ")
    long total(@Param("date") LocalDate date, @Param("type") String type);

    @Query("SELECT e FROM ExpenseTracker e WHERE YEAR(e.date) = :year AND MONTH(e.date) = :month ORDER BY e.date DESC")
    List<ExpenseTracker> findAllByMonthAndYear(@Param("year") int year, @Param("month") int month);

    @Query("SELECT SUM(e.cost) FROM ExpenseTracker e WHERE YEAR(e.date) = :year AND MONTH(e.date) = :month AND e.type = :type ")
    long total(@Param("year") int year, @Param("month") int month, @Param("type") String type);

    @Query("SELECT SUM(e.cost) FROM ExpenseTracker e WHERE e.type = :type AND e.category =:category")
    long findCostByTypeCategory(String type, String category);

    @Query("SELECT e FROM ExpenseTracker e WHERE YEAR(e.date) = :year ORDER BY e.date DESC")
    List<ExpenseTracker> findAllByYear(@Param("year") int year);

    @Query("SELECT SUM(e.cost) FROM ExpenseTracker e WHERE YEAR(e.date) = :year AND e.type = :type ")
    long total(@Param("year") int year, @Param("type") String type);


}
