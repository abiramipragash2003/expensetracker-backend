package com.zuci.expensetracker.Service;

import com.zuci.expensetracker.Config.ExpenseTrackerSecurityConfig;
import com.zuci.expensetracker.Dto.Register;
import com.zuci.expensetracker.Model.UserDb;
import com.zuci.expensetracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ExpenseTrackerSecurityConfig expenseTrackerSecurityConfig;

    public UserDb createRegistration(Register register) {
        UserDb userDb = new UserDb(0, register.getUsername(), passwordEncoder.encode(register.getUserPassword()), register.getUserMailId(), register.getUserMobileNumber(), register.getRoles());
        return userRepository.save(userDb);
    }

}
