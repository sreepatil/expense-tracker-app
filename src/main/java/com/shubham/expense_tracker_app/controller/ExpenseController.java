package com.shubham.expense_tracker_app.controller;

import com.shubham.expense_tracker_app.dto.ExpenseDto;
import com.shubham.expense_tracker_app.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){

        ExpenseDto expenseDto1 = expenseService.createExpense(expenseDto);

        return ResponseEntity.status(201).body(expenseDto1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpense(@PathVariable Long id){

        ExpenseDto expenseDto = expenseService.getExpense(id);

        return ResponseEntity.status(200).body(expenseDto);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(){
        List<ExpenseDto> expenseDto1 = expenseService.getAllExpenses();

        return ResponseEntity.status(200).body(expenseDto1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long id,
                                                    @RequestBody ExpenseDto expenseDto){
        ExpenseDto expenseDto1 = expenseService.updateExpense(id, expenseDto);

        return ResponseEntity.status(200).body(expenseDto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);

        return ResponseEntity.status(200).body("Expense Deleted Successfully !");
    }

}
