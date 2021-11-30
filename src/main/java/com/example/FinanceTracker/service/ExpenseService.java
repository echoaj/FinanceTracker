package com.example.FinanceTracker.service;

import com.example.FinanceTracker.dao.ExpenseDao;
import com.example.FinanceTracker.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseDao expenseDao;

    @Autowired
    public ExpenseService(@Qualifier("expenseDao") ExpenseDao expenseDao) {
        System.out.println("FROM EXPENSE SERVICE CONSTRUCTOR");
        this.expenseDao = expenseDao;
    }

    // GET-GET-GET-GET-GET
    public List<Expense> getExpenses(){
        return expenseDao.selectExpenses();
    }

    // POST-POST-POST-POST-POST
    public boolean postExpense(Expense expense) {
        System.out.println("FROM EXPENSE SERVICE addExpense");
        return expenseDao.addExpense(expense);
    }

    public boolean deleteExpense(String id) {
        return expenseDao.removeExpense(id);
    }

    public boolean putExpense(String id, Expense expense) {
        return expenseDao.updateExpense(id, expense);
    }
}
