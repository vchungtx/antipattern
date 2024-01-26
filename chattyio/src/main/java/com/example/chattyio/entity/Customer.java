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
@Table(name = "Customer"
, catalog = "antipattern"
)
public class Customer {
	
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CustomerID", unique = true, nullable = false)
	private Long customerID;
    
    @Column(name = "AccountNumber")
	private String accountNumber;
    
    @Column(name = "PersonID")
	private Long personID;
}
