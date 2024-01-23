package com.example.chattyio.controller;

import com.example.chattyio.entity.Product;
import com.example.chattyio.entity.ProductPriceHistory;
import com.example.chattyio.entity.ProductSubCategory;
import com.example.chattyio.repository.ProductPriceHistoryRepository;
import com.example.chattyio.repository.ProductRepository;
import com.example.chattyio.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ChattyController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductPriceHistoryRepository productPriceHistoryRepository;
    @GetMapping("/subcategories/{subcategoryId}")
    public ResponseEntity<ProductSubCategory> getProductsInSubCategory(@PathVariable int subcategoryId) {
        try {
            // Get product subcategory.
            ProductSubCategory productSubcategory = productService.getProductSubcategory(subcategoryId);

            // Find products in that category.
            List<Product> products = productService.getProductsBySubcategoryId(subcategoryId);
            productSubcategory.setProducts(products);

            // Find price history for each product.
            for (Product product : products) {
                int productId = product.getId();
                List<ProductPriceHistory> productListPriceHistory = productPriceHistoryRepository.findByProductId(productId);
                product.setProductPriceHistories(productListPriceHistory);
            }

            return new ResponseEntity<>(productSubcategory, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
