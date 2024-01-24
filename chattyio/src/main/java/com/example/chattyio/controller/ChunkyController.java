package com.example.chattyio.controller;

import com.example.chattyio.entity.Category;
import com.example.chattyio.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chunky")
public class ChunkyController {
    @Autowired
    ProductService productService;

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<Category> getProductsInSubCategory(@PathVariable int categoryId) {
        try {
            // Get product subcategory with product list price history included.
            Category category = productService.getProductCategoryDetails(categoryId);

            if (category == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
