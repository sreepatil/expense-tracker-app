package com.shubham.expense_tracker_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Standard error response returned by the API")
public class ErrorResponse{
        @Schema(
                description = "Date and time when the error occurred",
                example = "2026-09-04"
        )
        private LocalDate timestamp;

        @Schema(
                description = "Additional details about the error",
                example = "Category with ID 10 not found"
        )
        private String details;

        @Schema(
                description = "Unique code identifying the type of error",
                example = "CATEGORY_NOT_FOUND"
        )
        private String errorCode;

        @Schema(
                description = "Human-readable error message",
                example = "The requested category does not exist"
        )
        private String message;
}
