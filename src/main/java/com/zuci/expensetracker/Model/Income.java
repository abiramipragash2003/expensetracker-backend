package com.zuci.expensetracker.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Income {
    @Id
    private long incomeId;
    private String username;
    private String incomeCategory;
    private String incomeName;
    private long totalIncome;
    private Date incomeDate;
}
