package com.zuci.expensetracker.Repository;

import com.zuci.expensetracker.Model.ExpenseTracker;
import com.zuci.expensetracker.Model.UserDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseTrackerRepository extends JpaRepository<ExpenseTracker, Long> {

    @Query("SELECT e FROM ExpenseTracker e WHERE e.userdb.username = :username")
    List<ExpenseTracker> findByUserName(@Param("username") String username);
    @Query("SELECT e FROM ExpenseTracker e WHERE e.date = :date AND e.userdb.username = :username")
    List<ExpenseTracker> findAllByDateAndUsername(@Param("date")LocalDate expenseDate,@Param("username") String username);

    @Query("SELECT SUM(e.cost) FROM ExpenseTracker e WHERE e.date = :date AND e.type= :type AND e.userdb.username=:username")
    long total(@Param("date") LocalDate date, @Param("type") String type, @Param("username") String username);

    @Query("SELECT e FROM ExpenseTracker e WHERE YEAR(e.date) = :year AND MONTH(e.date) = :month AND e.userdb.username=:username ORDER BY e.date DESC")
    List<ExpenseTracker> findAllByMonthAndYear(@Param("year") int year, @Param("month") int month, @Param("username") String username);

    @Query("SELECT SUM(e.cost) FROM ExpenseTracker e WHERE YEAR(e.date) = :year AND MONTH(e.date) = :month AND e.type = :type AND e.userdb.username=:username")
    long total(@Param("year") int year, @Param("month") int month, @Param("type") String type, @Param("username") String username);

    @Query("SELECT SUM(e.cost) FROM ExpenseTracker e WHERE e.type = :type AND e.category =:category AND e.userdb.username=:username")
    long findCostByTypeCategory(String type, String category, @Param("username") String username);

    @Query("SELECT e FROM ExpenseTracker e WHERE YEAR(e.date) = :year AND e.userdb.username=:username ORDER BY e.date DESC")
    List<ExpenseTracker> findAllByYear(@Param("year") int year, @Param("username") String username);

    @Query("SELECT SUM(e.cost) FROM ExpenseTracker e WHERE YEAR(e.date) = :year AND e.type = :type AND e.userdb.username=:username")
    long total(@Param("year") int year, @Param("type") String type, @Param("username") String username);


}



