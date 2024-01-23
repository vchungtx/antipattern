package com.example.chattyio.repository;

import com.example.chattyio.entity.Product;
import com.example.chattyio.entity.ProductSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, Integer> {
}
