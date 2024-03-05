package com.zuci.expensetracker.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Income {
    @Id
    private String username;
    private String incomeCategory;
    private String incomeName;
    private long totalIncome;
}
