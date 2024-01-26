package com.example.chattyio.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "SalesOrderDetail"
, catalog = "antipattern"
)
public class SalesOrderDetail {
	
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "SalesOrderDetailID", unique = true, nullable = false)
	private Long salesOrderDetailID;
    
    @Column(name = "SalesOrderID")
	private Long salesOrderID;
    
    @Column(name = "OrderQty")
	private Long orderQty;
    
    @Column(name = "UnitPrice")
	private Float unitPrice;
    
    @Column(name = "LineTotal")
	private Float lineTotal;
    
    @Column(name = "ProductID")
	private Long productID;
}
