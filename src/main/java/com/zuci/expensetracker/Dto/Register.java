package com.zuci.expensetracker.Dto;

import com.zuci.expensetracker.Model.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class Register {

    @NotBlank(message = "Username should not be blank")
    @Column(unique = true)
    private String userName;
    @NotBlank(message = "UserPassword should not be blank")
    @Column(unique = true)
    private String userPassword;
    @NotBlank(message = "UserMailId should not be blank")
    @Column(unique = true)
    private String userMailId;
    @NotBlank(message = "UserMobileNumber should not be blank")
    @Column(unique = true)
    private String userMobileNumber;
    private List<Role> roles;
}
