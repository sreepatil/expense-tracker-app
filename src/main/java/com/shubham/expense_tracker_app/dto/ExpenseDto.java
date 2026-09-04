package com.shubham.expense_tracker_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(
        description = "Expense DTO (Data Transfer Object) to transfer the data between client & server"
)
public record ExpenseDto(Long id,
                         @Schema(
                                 description = "Expense amount", example = "1"
                         )
                         BigDecimal amount,

                         @Schema(
                                 description = "Date when the expense occurred", example = "2026-08-06"
                         )
                         LocalDate expenseDate,

                         @Schema(
                                 description = "Category associated with the expense"
                         )
                         CategoryDto categoryDto) {
}
