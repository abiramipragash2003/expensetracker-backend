package com.zuci.expensetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ExpensetrackerApplication {

	public static void main(String[] args) {
		LocalDate date= LocalDate.parse("2002-02-01");
		SpringApplication.run(ExpensetrackerApplication.class, args);
		System.out.println(date.getYear());
	}

}
