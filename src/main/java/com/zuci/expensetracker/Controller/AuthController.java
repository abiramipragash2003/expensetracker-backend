package com.zuci.expensetracker.Controller;

import com.zuci.expensetracker.Dto.Login;
import com.zuci.expensetracker.Dto.Register;
import com.zuci.expensetracker.Service.JwtUtilityService;
import com.zuci.expensetracker.Service.RegisterService;
import com.zuci.expensetracker.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        if (auth != null) {

            SecurityContextHolder.getContext().setAuthentication(null);
            request.getSession().invalidate();
            response.sendRedirect("/login?logout");
            return "logout";
        } else {
            return "not";
        }
    }


}
