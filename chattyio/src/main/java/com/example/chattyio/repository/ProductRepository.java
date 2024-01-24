package com.example.chattyio.repository;

import com.example.chattyio.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Set<Product> findByCategoryId(Integer categoryId);
}
