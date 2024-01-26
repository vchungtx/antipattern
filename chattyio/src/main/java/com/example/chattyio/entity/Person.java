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
@Table(name = "Person"
, catalog = "antipattern"
)
public class Person {
	
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "BusinessEntityID", unique = true, nullable = false)
	private Long businessEntityID;
    
    @Column(name = "Title")
	private String title;
    
    @Column(name = "FirstName")
	private String firstName;
    
    @Column(name = "MiddleName")
	private String middleName;
    
    @Column(name = "LastName")
	private String lastName;
    
    @Column(name = "Suffix")
	private String suffix;
}
