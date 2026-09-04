package com.shubham.expense_tracker_app.exception;

public class ExpenseNotFound extends RuntimeException{

    public ExpenseNotFound(String message){
        super(message);
    }
}
