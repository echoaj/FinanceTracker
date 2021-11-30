package com.example.FinanceTracker.repos;

import com.example.FinanceTracker.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

// The API implementation happens in the repository.
// It acts as a link between the model and the database, and has all the methods for CRUD operations.
// Important, Since I defined the second parameter as String, that means that functions relating to
// This repository for mongo will take in a String for the ID
public interface ExpenseRepository extends MongoRepository<Expense, String> {
}
