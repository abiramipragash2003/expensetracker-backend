package com.zuci.expensetracker.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class Login {
    @NotBlank(message = "Username should not be blank")
    @Column(unique = true)
    private String userName;

    @NotBlank(message = "Password should not be blank")
    @Column(unique = true)
    private String userPassword;

}
