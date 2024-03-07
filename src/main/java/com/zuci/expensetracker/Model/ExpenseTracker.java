package com.zuci.expensetracker.Model;
import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor


public class ExpenseTracker
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userName;

    private String type;

    private String category;

    private String name;

    private long cost;

    private LocalDate date;


    public ExpenseTracker(String username, String type, String category, String name, long cost, LocalDate date)
    {
        this.userName = username;
        this.type = type;
        this.category = category;
        this.name = name;
        this.cost = cost;
        this.date = date;

    }


}
