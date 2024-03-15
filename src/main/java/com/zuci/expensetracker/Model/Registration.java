package com.zuci.expensetracker.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String username;
    private String userPassword;
    private String userMailId;
    private String userMobileNumber;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roles;
}
