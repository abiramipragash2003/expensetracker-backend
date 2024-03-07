package com.zuci.expensetracker.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SignUp
{
    @Id
    private String userName;
    private String userPassword;
    private String userMailId;
    private String userMobileNumber;

}
