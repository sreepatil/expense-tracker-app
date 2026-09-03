package com.shubham.expense_tracker_app.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
public class ErrorResponse{
        private LocalDate timestamp;
        private String details;
        private String errorCode;
        private String message;
}
