package com.example.chattyio.repository;

import com.example.chattyio.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c JOIN FETCH c.products p JOIN FETCH p.priceHistories WHERE c.id = :categoryId")
    Category getProductCategoryDetails(int categoryId);
}
