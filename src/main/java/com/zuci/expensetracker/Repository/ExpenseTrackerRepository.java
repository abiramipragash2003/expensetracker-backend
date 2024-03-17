package com.zuci.expensetracker.Repository;

import com.zuci.expensetracker.Model.ExpenseTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseTrackerRepository extends JpaRepository<ExpenseTracker, Long> {

    List<ExpenseTracker> findAllByTypeAndUserName(String type, String userName);

    List<ExpenseTracker> findAllByDateAndUserName(LocalDate expenseDate, String userName);

    @Query("SELECT SUM(e.cost) FROM ExpenseTracker e WHERE e.date = :date AND e.type= :type AND e.userName=:username")
    long total(@Param("date") LocalDate date, @Param("type") String type, @Param("username") String username);

    @Query("SELECT e FROM ExpenseTracker e WHERE YEAR(e.date) = :year AND MONTH(e.date) = :month AND e.userName=:username ORDER BY e.date DESC")
    List<ExpenseTracker> findAllByMonthAndYear(@Param("year") int year, @Param("month") int month, @Param("username") String username);

    @Query("SELECT SUM(e.cost) FROM ExpenseTracker e WHERE YEAR(e.date) = :year AND MONTH(e.date) = :month AND e.type = :type AND e.userName=:username")
    long total(@Param("year") int year, @Param("month") int month, @Param("type") String type, @Param("username") String username);

    @Query("SELECT SUM(e.cost) FROM ExpenseTracker e WHERE e.type = :type AND e.category =:category AND e.userName=:username")
    long findCostByTypeCategory(String type, String category, @Param("username") String username);

    @Query("SELECT e FROM ExpenseTracker e WHERE YEAR(e.date) = :year AND e.userName=:username ORDER BY e.date DESC")
    List<ExpenseTracker> findAllByYear(@Param("year") int year, @Param("username") String username);

    @Query("SELECT SUM(e.cost) FROM ExpenseTracker e WHERE YEAR(e.date) = :year AND e.type = :type AND e.userName=:username")
    long total(@Param("year") int year, @Param("type") String type, @Param("username") String username);


}



