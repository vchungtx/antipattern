package com.example.chattyio.service;

import com.example.chattyio.entity.Category;
import com.example.chattyio.entity.PriceHistory;
import com.example.chattyio.entity.Product;
import com.example.chattyio.repository.CategoryRepository;
import com.example.chattyio.repository.PriceHistoryRepository;
import com.example.chattyio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

     public Category getCategory(Integer categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    public Set<Product> getProductsByCategoryId(Integer categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public Set<PriceHistory> getPriceHistoriesByProductId(Integer productId) {
        return priceHistoryRepository.findByProductId(productId);
    }

    public Category getProductCategoryDetails(int categoryId) {
        return categoryRepository.getProductCategoryDetails(categoryId);
    }
}
