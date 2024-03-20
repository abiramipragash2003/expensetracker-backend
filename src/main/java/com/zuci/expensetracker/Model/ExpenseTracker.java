package com.zuci.expensetracker.Model;

import jakarta.persistence.*;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor

public class ExpenseTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "username")
    private UserDb userdb;

    //type is either income or expense
    private String type;

    private String category;

    //additional notes given by user
    private String name;

    private long cost;

    private LocalDate date;

    public ExpenseTracker(UserDb userdb, String type, String category, String name, long cost, LocalDate date) {
        this.userdb = userdb;
        this.type = type;
        this.category = category;
        this.name = name;
        this.cost = cost;
        this.date = date;
    }

}
