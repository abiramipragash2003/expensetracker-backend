package com.zuci.expensetracker.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data

public class AddIncome {

    @NotEmpty(message = "Type must not be empty")
    private String type;

    @NotEmpty(message = "Category must not be empty")
    private String incomeCategory;

    private String incomeName;

    @Positive(message = "Cost should not be negative")
    private long cost = 0;

    private LocalDate incomeDate;

}
