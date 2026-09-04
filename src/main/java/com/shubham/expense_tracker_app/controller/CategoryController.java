package com.shubham.expense_tracker_app.controller;

import com.shubham.expense_tracker_app.dto.CategoryDto;
import com.shubham.expense_tracker_app.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD Rest API for expense resource",
        description = "CRUD Rest API for expense resource Create Category, Get Category, Update Category" +
                "Delete Category"
)

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(
            summary = "Create Category Rest API",
            description = "Create Category Rest API to save category into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 OK"
    )
    @PostMapping("/add")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
           CategoryDto categoryDto1 = categoryService.createCategory(categoryDto);

           return ResponseEntity.status(201).body(categoryDto1);
    }

    @Operation(
            summary = "Get Category Rest API",
            description = "Get Category Rest API to get category using Id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id){
        CategoryDto categoryDto = categoryService.getCategory(id);

        return ResponseEntity.status(200).body(categoryDto);
    }

    @Operation(
            summary = "Get All category Rest API",
            description = "Get All category Rest API to get all categories"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> categoryDtos = categoryService.getAllCategory();

        return ResponseEntity.status(200).body(categoryDtos);
    }

    @Operation(
            summary = "Update Category Rest API",
            description = "Update Category Rest API to update the existing category"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto){

        CategoryDto categoryDto1 = categoryService.updateCategory(id, categoryDto);

        return ResponseEntity.status(200).body(categoryDto1);
    }

    @Operation(
            summary = "DELETE Category Rest API",
            description = "DELETE Category Rest API to delete the category"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS CODE 200 OK"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){

        categoryService.deleteCategory(id);

        return ResponseEntity.status(200).body("Category deleted Successfully !");
    }
}
