package com.example.chattyio.service;

import com.example.chattyio.entity.Product;
import com.example.chattyio.entity.ProductPriceHistory;
import com.example.chattyio.entity.ProductSubCategory;
import com.example.chattyio.repository.ProductPriceHistoryRepository;
import com.example.chattyio.repository.ProductRepository;
import com.example.chattyio.repository.ProductSubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductSubCategoryRepository productSubCategoryRepository;
    @Autowired
    private ProductPriceHistoryRepository productPriceHistoryRepository;

     public ProductSubCategory getProductSubcategory(Integer subcategoryId) {
        return productSubCategoryRepository.findById(subcategoryId).get();
    }

    public List<Product> getProductsBySubcategoryId(Integer subcategoryId) {
        return productRepository.findByProductSubCategoryId(subcategoryId);
    }

    public List<ProductPriceHistory> getProductPriceHistory(Integer productId) {
        return productPriceHistoryRepository.findByProductId(productId);
    }
}
