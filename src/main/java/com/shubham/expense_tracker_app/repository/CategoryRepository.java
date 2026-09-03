package com.shubham.expense_tracker_app.repository;

import com.shubham.expense_tracker_app.entity.Category;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
