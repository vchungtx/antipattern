package com.example.chattyio.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

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
@Table(name = "SalesOrderHeader"
, catalog = "antipattern"
)
public class SalesOrderHeader {
	
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "SalesOrderID", unique = true, nullable = false)
	private Long salesOrderID;
    
    @Column(name = "SalesOrderNumber")
	private String salesOrderNumber;
    
    @Column(name = "Status")
	private String status;
    
    @Column(name = "OrderDate")
	private Date orderDate;
    
    @Column(name = "DueDate")
	private Date dueDate;
    
    @Column(name = "ShipDate")
	private Date shipDate;
    
    @Column(name = "SubTotal")
	private Float subTotal;
    
    @Column(name = "TaxAmt")
	private String taxAmt;
    
    @Column(name = "TotalDue")
	private Float totalDue;
    
    @Column(name = "TerritoryId")
	private String territoryId;
    
    @Column(name = "CustomerID")
	private Long customerID;
	
}
