package com.example.FinanceTracker.dao;

import com.example.FinanceTracker.model.Expense;
import com.example.FinanceTracker.repos.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("expenseDao")
public class ExpenseDataAccess implements ExpenseDao{

    @Autowired
    ExpenseRepository expenseItemRepo;

    @Override   // POST-POST-POST-POST-POST
    public boolean addExpense(Expense expense) {
        System.out.println("FROM EXPENSE DAO CLASS");
        expenseItemRepo.insert(expense);    // can also do .save(expense) - that would insert or update query
        showAllExpenseItems();
        return true;    // response
    }

    @Override   // GET-GET-GET-GET-GET
    public List<Expense> selectExpenses() {
        return new ArrayList<>(expenseItemRepo.findAll());
    }

    @Override
    public boolean removeExpense(String id) {
        System.out.println(" DELETING FROM DB ITEM: " + id);
        expenseItemRepo.deleteById(id);
        return true;    // response
    }

    @Override   // PUT-PUT-PUT-PUT-PUT
    public boolean updateExpense(String id, Expense expense) {
        Expense updatedExpense = new Expense(id, expense.getItem());
        expenseItemRepo.save(updatedExpense);
        return true;    // response
    }

    // TESTING PURPOSES
    public void showAllExpenseItems() {
        System.out.println("\n showAllExpenseItems");
        // .findAll() calls the constructor for all Expense objects
        expenseItemRepo.findAll().forEach(expense ->
                System.out.println("-ID: " + expense.getId() + "\tExpense: " + expense.getItem()));
    }
}
