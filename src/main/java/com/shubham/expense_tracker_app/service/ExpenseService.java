package com.shubham.expense_tracker_app.service;

import com.shubham.expense_tracker_app.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto expenseDto);

    ExpenseDto getExpense(Long id);

    List<ExpenseDto> getAllExpenses();

    ExpenseDto updateExpense(Long id, ExpenseDto expenseDto);

    void deleteExpense(Long id);
}
