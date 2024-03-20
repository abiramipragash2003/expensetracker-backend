package com.zuci.expensetracker.Repository;

import com.zuci.expensetracker.Model.UserDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDb, Long> {
    Optional<UserDb> findByUsername(String userName);
}
