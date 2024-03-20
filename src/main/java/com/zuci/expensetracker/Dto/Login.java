package com.zuci.expensetracker.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Login {

    @NotBlank(message = "Username should not be blank")
    private String username;

    @NotBlank(message = "Password should not be blank")
    private String userPassword;

}
