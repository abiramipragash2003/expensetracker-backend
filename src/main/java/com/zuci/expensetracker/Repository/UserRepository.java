package com.zuci.expensetracker.Repository;

import com.zuci.expensetracker.Model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Registration, Long> {

    Registration findByUsername(String userName);
}
