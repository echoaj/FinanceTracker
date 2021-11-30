package com.example.FinanceTracker.dao;

import com.example.FinanceTracker.model.Expense;

import java.util.List;

public interface ExpenseDao {

    List<Expense> selectExpenses();
    boolean addExpense(Expense expense);
    boolean removeExpense(String id);
    boolean updateExpense(String id, Expense expense);

}
