package com.example.chattyio.entity;
// Generated Jan 23, 2024 10:46:56 PM by Hibernate Tools 4.3.1


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="product"
    ,catalog="antipattern"
)
public class Product  implements java.io.Serializable {


     private Integer id;
     private Integer productSubCategoryId;
     private String name;
    private List<ProductPriceHistory> productPriceHistories;

    public Product() {
    }

    public Product(Integer productSubCategoryId, String name) {
       this.productSubCategoryId = productSubCategoryId;
       this.name = name;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="product_sub_category_id")
    public Integer getProductSubCategoryId() {
        return this.productSubCategoryId;
    }
    
    public void setProductSubCategoryId(Integer productSubCategoryId) {
        this.productSubCategoryId = productSubCategoryId;
    }

    
    @Column(name="name", length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany()
    public List<ProductPriceHistory> getProductPriceHistories() {
        return productPriceHistories;
    }

    public void setProductPriceHistories(List<ProductPriceHistory> productPriceHistories) {
        this.productPriceHistories = productPriceHistories;
    }
}

