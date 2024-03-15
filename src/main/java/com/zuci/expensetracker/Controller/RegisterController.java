package com.zuci.expensetracker.Controller;

import com.zuci.expensetracker.Dto.Login;
import com.zuci.expensetracker.Dto.Register;
import com.zuci.expensetracker.Model.Registration;
import com.zuci.expensetracker.Service.JwtUtilityService;
import com.zuci.expensetracker.Service.RegisterService;
import com.zuci.expensetracker.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private UserService UserService;

    @Autowired
    private JwtUtilityService jwtUtilityService;
    @PostMapping("/signup")
    public Registration createRegistration(@Valid @RequestBody Register register){
        return registerService.createRegistration(register);
    }
    @PostMapping("/login")
    public String createUser(@RequestBody Login login) {
        if (UserService.loadUserByUsername(login.getUserName()) == null) {
            return "Invalid credentials";
        }
        return jwtUtilityService.generateToken(login.getUserName());
    }


}
