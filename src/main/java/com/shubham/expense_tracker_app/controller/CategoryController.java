package com.shubham.expense_tracker_app.controller;

import com.shubham.expense_tracker_app.dto.CategoryDto;
import com.shubham.expense_tracker_app.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
           CategoryDto categoryDto1 = categoryService.createCategory(categoryDto);

           return ResponseEntity.status(201).body(categoryDto1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id){
        CategoryDto categoryDto = categoryService.getCategory(id);

        return ResponseEntity.status(200).body(categoryDto);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> categoryDtos = categoryService.getAllCategory();

        return ResponseEntity.status(200).body(categoryDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto){

        CategoryDto categoryDto1 = categoryService.updateCategory(id, categoryDto);

        return ResponseEntity.status(200).body(categoryDto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){

        categoryService.deleteCategory(id);

        return ResponseEntity.status(200).body("Category deleted Successfully !");
    }
}
