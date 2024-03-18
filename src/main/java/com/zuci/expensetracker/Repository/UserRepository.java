package com.zuci.expensetracker.Repository;

import com.zuci.expensetracker.Model.UserDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDb, Long> {

    UserDb findByUsername(String userName);
}
