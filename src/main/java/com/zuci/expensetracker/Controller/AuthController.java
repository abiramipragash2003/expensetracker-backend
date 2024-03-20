package com.zuci.expensetracker.Controller;

import com.zuci.expensetracker.Dto.Login;
import com.zuci.expensetracker.Dto.Register;
import com.zuci.expensetracker.Service.JwtUtilityService;
import com.zuci.expensetracker.Service.RegisterService;
import com.zuci.expensetracker.Service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")

public class AuthController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private UserService UserService;

    @Autowired
    private JwtUtilityService jwtUtilityService;

    @PostMapping("/signup")
    public String createRegistration(@Valid @RequestBody Register register) {

        registerService.createRegistration(register);
        return jwtUtilityService.generateToken(register.getUsername());
    }

    @PostMapping("/login")
    public String createUser(@RequestBody Login login) {
        if (UserService.loadUserByUsername(login.getUsername()) == null) {
            return "Invalid credentials";
        }
        return jwtUtilityService.generateToken(login.getUsername());
    }

    @GetMapping("/username/{username}")
    public String validateUsername(@PathVariable String username) {
        return UserService.checkUsername(username);
    }
}
