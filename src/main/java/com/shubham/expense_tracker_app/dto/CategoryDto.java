package com.shubham.expense_tracker_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(
        description = "Category DTO (Data Transfer Object) to transfer the data between client & server"
)
public record CategoryDto(
        Long id,

        @Schema(
                description = "Category name"
        )
        @NotBlank(message = "Category name is required")
        String name) {
}
