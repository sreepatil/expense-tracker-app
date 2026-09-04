package com.shubham.expense_tracker_app.controller;

import com.shubham.expense_tracker_app.dto.ExpenseDto;
import com.shubham.expense_tracker_app.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD Rest API for expense resource",
        description = "CRUD Rest API for expense resource to Create, Get, Update, Delete"
)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Operation(
            summary = "Create Expense Rest API",
            description = "Create Expense Rest API to create the expense"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS CODE 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){

        ExpenseDto expenseDto1 = expenseService.createExpense(expenseDto);

        return ResponseEntity.status(201).body(expenseDto1);
    }

    @Operation(
            summary = "Get Expense Rest API",
            description = "Get Expense Rest API to get the expense"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpense(@PathVariable Long id){

        ExpenseDto expenseDto = expenseService.getExpense(id);

        return ResponseEntity.status(200).body(expenseDto);
    }

    @Operation(
            summary = "Get All Expense Rest API",
            description = "Get All Expense Rest API to get all the expenses"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(){
        List<ExpenseDto> expenseDto1 = expenseService.getAllExpenses();

        return ResponseEntity.status(200).body(expenseDto1);
    }

    @Operation(
            summary = "Update Expense Rest API",
            description = "Update Expense Rest API to Update the existing expense"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long id,
                                                    @RequestBody ExpenseDto expenseDto){
        ExpenseDto expenseDto1 = expenseService.updateExpense(id, expenseDto);

        return ResponseEntity.status(200).body(expenseDto1);
    }

    @Operation(
            summary = "Delete Expense Rest API",
            description = "Delete Expense Rest API to Delete the existing expense"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);

        return ResponseEntity.status(200).body("Expense Deleted Successfully !");
    }

}
