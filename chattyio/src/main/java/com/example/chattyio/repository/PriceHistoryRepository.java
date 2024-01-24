package com.example.chattyio.repository;

import com.example.chattyio.entity.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Integer> {
    Set<PriceHistory> findByProductId(Integer productId);
}
