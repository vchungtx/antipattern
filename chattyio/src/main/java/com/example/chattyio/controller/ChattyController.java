package com.example.chattyio.controller;

import com.example.chattyio.entity.Category;
import com.example.chattyio.entity.PriceHistory;
import com.example.chattyio.entity.Product;
import com.example.chattyio.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/chatty")
public class ChattyController {
    @Autowired
    ProductService productService;

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<Category> getProductsInSubCategory(@PathVariable int categoryId) {
        try {
            // Get product category.
            Category category = productService.getCategory(categoryId);
            // Find products in that category.
            Set<Product> products = productService.getProductsByCategoryId(categoryId);
            category.setProducts(products);
            // Find price history for each product.
            for (Product product : products) {
                int productId = product.getId();
                Set<PriceHistory> priceHistories = productService.getPriceHistoriesByProductId(productId);
                product.setPriceHistories(priceHistories);
            }
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
