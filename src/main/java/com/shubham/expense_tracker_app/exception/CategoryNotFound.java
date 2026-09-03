package com.shubham.expense_tracker_app.exception;

public class CategoryNotFound extends RuntimeException{

    public CategoryNotFound(String message){
        super(message);
    }
}
