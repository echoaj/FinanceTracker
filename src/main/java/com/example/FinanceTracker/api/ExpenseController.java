package com.example.FinanceTracker.api;

import com.example.FinanceTracker.model.Expense;
import com.example.FinanceTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="https://finance-tracker-test1.herokuapp.com")
@RequestMapping("api/expense")
@RestController
public class ExpenseController {
    // Dependency
    private final ExpenseService expenseService;

    @Autowired                 // Injection
    public ExpenseController(ExpenseService expenseService) {
        System.out.println("FROM EXPENSE CONTROLLER CONSTRUCTOR");
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getAllExpenses(){
        return expenseService.getExpenses();
    }

    @PostMapping
    public boolean postOneExpense(@RequestBody Expense expense){
        return expenseService.postExpense(expense);
    }

    @DeleteMapping(path="{id}")
    public boolean deleteExpenseById(@PathVariable("id") String id){
        return expenseService.deleteExpense(id);
    }

    @PutMapping(path="{id}")
    public boolean putOneExpense(@PathVariable("id") String id, @RequestBody Expense expenseToUpdate){
        return expenseService.putExpense(id, expenseToUpdate);
    }
}
