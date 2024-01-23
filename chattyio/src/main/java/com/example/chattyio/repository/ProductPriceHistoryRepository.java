package com.example.chattyio.repository;

import com.example.chattyio.entity.ProductPriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductPriceHistoryRepository extends JpaRepository<ProductPriceHistory, Integer> {
    List<ProductPriceHistory> findByProductId(Integer productId);
}
