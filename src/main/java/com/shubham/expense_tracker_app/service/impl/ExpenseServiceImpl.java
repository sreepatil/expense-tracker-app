package com.shubham.expense_tracker_app.service.impl;

import com.shubham.expense_tracker_app.dto.ExpenseDto;
import com.shubham.expense_tracker_app.entity.Category;
import com.shubham.expense_tracker_app.entity.Expense;
import com.shubham.expense_tracker_app.exception.CategoryNotFound;
import com.shubham.expense_tracker_app.exception.ExpenseNotFound;
import com.shubham.expense_tracker_app.mapper.ExpenseMapper;
import com.shubham.expense_tracker_app.repository.CategoryRepository;
import com.shubham.expense_tracker_app.repository.ExpenseRepository;
import com.shubham.expense_tracker_app.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {

        Expense expense = ExpenseMapper.mapToExpense(expenseDto);

        Expense savedExpense = expenseRepository.save(expense);

        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpense(Long id) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFound("Expense Not Found !"));

        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {

        List<Expense> expenses = expenseRepository.findAll();

        return expenses.stream()
                .map((ExpenseMapper::mapToExpenseDto)).toList();

    }

    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFound("Expense not Found"));

        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());

        if (expenseDto.categoryDto() != null){
            Category category = categoryRepository.findById(expenseDto.categoryDto().id())
                    .orElseThrow(() -> new CategoryNotFound(
                            "Category not found " + expenseDto.categoryDto().id()));

            expense.setCategory(category);
        }

        Expense updateExpense = expenseRepository.save(expense);

        return ExpenseMapper.mapToExpenseDto(updateExpense);
    }

    @Override
    public void deleteExpense(Long id) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFound("Expense Not Found !" + id));

        expenseRepository.deleteById(id);

    }


}
