package com.zuci.expensetracker.Service;

import com.zuci.expensetracker.Dto.AddExpense;
import com.zuci.expensetracker.Dto.AddIncome;
import com.zuci.expensetracker.Dto.Response;
import com.zuci.expensetracker.Exception.IdNotFoundException;
import com.zuci.expensetracker.Model.ExpenseTracker;
import com.zuci.expensetracker.Repository.ExpenseTrackerRepository;
import com.zuci.expensetracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class ExpenseTrackerServiceImpl implements ExpenseTrackerService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ExpenseTrackerRepository expenseTrackerRepository;

    String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @Override
    public ExpenseTracker createExpense(AddExpense addExpense) {

        ExpenseTracker expenseTracker = new ExpenseTracker(userRepository.findByUsername(getCurrentUsername()).get(), addExpense.getType(), addExpense.getExpenseCategory(), addExpense.getExpenseName(), addExpense.getCost(), addExpense.getExpenseDate());
        return expenseTrackerRepository.save(expenseTracker);
    }

    @Override
    public ExpenseTracker createIncome(AddIncome addIncome) {

        ExpenseTracker expenseTracker = new ExpenseTracker(userRepository.findByUsername(getCurrentUsername()).get(), addIncome.getType(), addIncome.getIncomeCategory(), addIncome.getIncomeName(), addIncome.getCost(), addIncome.getIncomeDate());
        return expenseTrackerRepository.save(expenseTracker);
    }

    @Override
    public String deleteById(long id) {
        String status = null;
        Optional<ExpenseTracker> optional = expenseTrackerRepository.findById(id);
        if (optional.isPresent()) {
            expenseTrackerRepository.deleteById(id);
            status = "deleted successfully";

        } else {

            throw new IdNotFoundException();

        }
        return status;

    }

    @Override
    public Response getAllByDate(LocalDate date) {
        long totalIncome = 0, totalExpense = 0;
        List<ExpenseTracker> expenseTrackerList = expenseTrackerRepository.findAllByDateAndUsername(date, getCurrentUsername());
        String[] incomeCategory = {"Salary", "Investment", "Awards", "Others"};
        String[] expenseCategory = {"Shopping", "Food", "Telephone", "Entertainment", "Education",
                "Beauty", "Transportation", "Clothes", "Electronics", "Travel", "Health", "Gifts", "Others"};
        long total = 0;
        Map<String, Long> incomeMap = new HashMap<>();//key value pair
        Map<String, Long> expenseMap = new HashMap<>();
        Response response = new Response();

        if (!expenseTrackerList.isEmpty())//list is not empty
        {
            response.setExpenseTracker(expenseTrackerList);
            try {
                totalExpense = expenseTrackerRepository.total(date, "expense", getCurrentUsername());
            } catch (Exception e) {
                totalExpense = 0;
            }
            try {
                totalIncome = expenseTrackerRepository.total(date, "income", getCurrentUsername());
            } catch (Exception e) {
                totalIncome = 0;
            }
            long balance = totalIncome - totalExpense;
            response.setTotalExpense(totalExpense);
            response.setTotalIncome(totalIncome);
            response.setBalance(balance);


            for (int i = 0; i < incomeCategory.length; i++) {
                try {
                    total = expenseTrackerRepository.findCostByTypeCategoryAndDate("income", incomeCategory[i], date, getCurrentUsername());
                    incomeMap.put(incomeCategory[i], total);//to add key and values in hash map
                    total = 0;
                } catch (Exception e) {
                    incomeMap.put(incomeCategory[i], total);
                    total = 0;
                }
            }


            for (int i = 0; i < expenseCategory.length; i++) {
                try {
                    total = expenseTrackerRepository.findCostByTypeCategoryAndDate("expense", expenseCategory[i], date, getCurrentUsername());
                    expenseMap.put(expenseCategory[i], total);
                    total = 0;
                } catch (Exception e) {
                    expenseMap.put(expenseCategory[i], total);
                    total = 0;
                }
            }


            response.setIncomeMap(incomeMap);
            response.setExpenseMap(expenseMap);

        }

        return response;

    }

    @Override
    public Response getAllByMonthAndYear(LocalDate monthAndYear) {
        long totalIncome = 0, totalExpense = 0;
        int year = monthAndYear.getYear();
        int month = monthAndYear.getMonthValue();
        Response response = new Response();
        List<ExpenseTracker> expenseTrackerList = expenseTrackerRepository.findAllByMonthAndYear(year, month, getCurrentUsername());
        String[] incomeCategory = {"Salary", "Investment", "Awards", "Others"};
        String[] expenseCategory = {"Shopping", "Food", "Telephone", "Entertainment", "Education",
                "Beauty", "Transportation", "Clothes", "Electronics", "Travel", "Health", "Gifts", "Others"};
        long total = 0;
        Map<String, Long> incomeMap = new HashMap<>();//key value pair
        Map<String, Long> expenseMap = new HashMap<>();
        if (!expenseTrackerList.isEmpty())//list is not empty
        {
            response.setExpenseTracker(expenseTrackerList);
            try {
                totalExpense = expenseTrackerRepository.total(year, month, "expense", getCurrentUsername());
            } catch (Exception e) {
                totalExpense = 0;
            }
            try {
                totalIncome = expenseTrackerRepository.total(year, month, "income", getCurrentUsername());
            } catch (Exception e) {
                totalIncome = 0;
            }
            long balance = totalIncome - totalExpense;
            response.setTotalExpense(totalExpense);
            response.setTotalIncome(totalIncome);
            response.setBalance(balance);


            for (int i = 0; i < incomeCategory.length; i++) {
                try {
                    total = expenseTrackerRepository.findCostByTypeCategoryAndMonthAndYear("income", incomeCategory[i], year, month, getCurrentUsername());
                    incomeMap.put(incomeCategory[i], total);//to add key and values in hash map
                    total = 0;
                } catch (Exception e) {
                    incomeMap.put(incomeCategory[i], total);
                    total = 0;
                }
            }


            for (int i = 0; i < expenseCategory.length; i++) {
                try {
                    total = expenseTrackerRepository.findCostByTypeCategoryAndMonthAndYear("expense", expenseCategory[i], year, month, getCurrentUsername());
                    expenseMap.put(expenseCategory[i], total);
                    total = 0;
                } catch (Exception e) {
                    expenseMap.put(expenseCategory[i], total);
                    total = 0;
                }
            }


            response.setIncomeMap(incomeMap);
            response.setExpenseMap(expenseMap);

        }


        return response;
    }

    @Override
    public Response getAllByYear(LocalDate inputyear) {
        long totalIncome = 0, totalExpense = 0;
        int yeartaken = inputyear.getYear();
        Response response = new Response();
        String[] incomeCategory = {"Salary", "Investment", "Awards", "Others"};
        String[] expenseCategory = {"Shopping", "Food", "Telephone", "Entertainment", "Education",
                "Beauty", "Transportation", "Clothes", "Electronics", "Travel", "Health", "Gifts", "Others"};
        long total = 0;
        Map<String, Long> incomeMap = new HashMap<>();//key value pair
        Map<String, Long> expenseMap = new HashMap<>();
        List<ExpenseTracker> expenseTrackerList = expenseTrackerRepository.findAllByYear(yeartaken, getCurrentUsername());
        if (!expenseTrackerList.isEmpty())//list is not empty
        {
            response.setExpenseTracker(expenseTrackerList);
            try {
                totalExpense = expenseTrackerRepository.total(yeartaken, "expense", getCurrentUsername());
            } catch (Exception e) {
                totalExpense = 0;
            }
            try {
                totalIncome = expenseTrackerRepository.total(yeartaken, "income", getCurrentUsername());
            } catch (Exception e) {
                totalIncome = 0;
            }
            long balance = totalIncome - totalExpense;
            response.setTotalExpense(totalExpense);
            response.setTotalIncome(totalIncome);
            response.setBalance(balance);
            for (int i = 0; i < incomeCategory.length; i++) {
                try {
                    total = expenseTrackerRepository.findCostByTypeCategoryAndYear("income", incomeCategory[i], yeartaken, getCurrentUsername());
                    incomeMap.put(incomeCategory[i], total);//to add key and values in hash map
                    total = 0;
                } catch (Exception e) {
                    incomeMap.put(incomeCategory[i], total);
                    total = 0;
                }
            }


            for (int i = 0; i < expenseCategory.length; i++) {
                try {
                    total = expenseTrackerRepository.findCostByTypeCategoryAndYear("expense", expenseCategory[i], yeartaken, getCurrentUsername());
                    expenseMap.put(expenseCategory[i], total);
                    total = 0;
                } catch (Exception e) {
                    expenseMap.put(expenseCategory[i], total);
                    total = 0;
                }
            }
            response.setIncomeMap(incomeMap);
            response.setExpenseMap(expenseMap);


        }

        return response;


    }

    @Override
    public ExpenseTracker updateById(long id, ExpenseTracker expenseTracker) {
        ExpenseTracker expenseTracker1 = expenseTrackerRepository.findById(id).get();
        if (expenseTracker.getCategory() != null) {
            expenseTracker1.setCategory(expenseTracker.getCategory());
        }
        if (expenseTracker.getCost() != 0) {
            expenseTracker1.setCost(expenseTracker.getCost());
        }
        if (expenseTracker.getName() != null) {
            expenseTracker1.setName(expenseTracker.getName());
        }
        return expenseTrackerRepository.save(expenseTracker1);
    }


}
