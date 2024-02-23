package com.example.chattyio.service;

import com.example.chattyio.entity.Category;
import com.example.chattyio.entity.PriceHistory;
import com.example.chattyio.entity.Product;
import com.example.chattyio.repository.CategoryRepository;
import com.example.chattyio.repository.PriceHistoryRepository;
import com.example.chattyio.repository.ProductRepository;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    public Category getCategory(Integer categoryId) {
        return categoryRepository.findById(categoryId).get();
    }
    public Product getProduct(Integer id) {
        return productRepository.findById(id).get();
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

    @SneakyThrows
    public String getProductsWithoutCaching() {
        return "Total product: " + productRepository.count();
    }

    @SneakyThrows
    @Cacheable(value = "myCache", key = "'totalProduct'")
    public String getProductsWithCaching() {
        return "Total product: " + productRepository.count();
    }
}
