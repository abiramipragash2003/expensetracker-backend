package com.zuci.expensetracker.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor

public class ExpenseTracker
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String type;
    private String Category;
    private String Name;
    private long cost;
    private LocalDate Date;

    public ExpenseTracker(String username, String type, String category, String name, long cost, LocalDate date) {
        this.username = username;
        this.type = type;
        Category = category;
        Name = name;
        this.cost = cost;
        Date = date;
    }
    //    private long totalExpense;
//    private long totalIncome;

}
