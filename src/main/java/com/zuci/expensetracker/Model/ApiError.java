package com.zuci.expensetracker.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
public class ApiError {
    private String Path;
    private String message;
    private Date date;
}
