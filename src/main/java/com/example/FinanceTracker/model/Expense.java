package com.example.FinanceTracker.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data                   // Generates Constructor, Getters, And Setter for us
@Document("table")      // Store Documents within collection
public class Expense {
    @Id
    private final String id;
    private final String item;

}
