package com.zuci.expensetracker.Service;

import com.zuci.expensetracker.Dto.Register;
import com.zuci.expensetracker.Model.UserDb;


public interface RegisterService {

    public UserDb createRegistration(Register register);


}
