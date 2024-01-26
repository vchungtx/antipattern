package com.example.chattyio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.chattyio.entity.Customer;
import com.example.chattyio.projection.CustomerSummaryManyProcProjection;
import com.example.chattyio.projection.CustomerSummaryProjection;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "SELECT c.CustomerID AS customerID, c.AccountNumber AS accountNumber, "
			+ "p.Title AS title, p.FirstName AS firstName, p.LastName AS lastName, "
			+ "soh.SalesOrderID AS salesOrderID, sod.OrderQty AS orderQty " + "FROM Customer c "
			+ "INNER JOIN Person p ON c.PersonID = p.BusinessEntityID "
			+ "LEFT JOIN SalesOrderHeader soh ON c.CustomerID = soh.CustomerID "
			+ "LEFT JOIN SalesOrderDetail sod ON soh.SalesOrderID = sod.SalesOrderID", nativeQuery = true)
	List<CustomerSummaryProjection> getCustomerSummary();
	
	
	@Query(value = "SELECT\r\n"
			+ "	c.CustomerID as customerID,\r\n"
			+ "	c.AccountNumber as accountNumber,\r\n"
			+ "	CONCAT(p.Title, ' ', p.FirstName, ' ', p.LastName) AS fullName,\r\n"
			+ "	COUNT(soh.SalesOrderID) AS totalOrders,\r\n"
			+ "	CASE\r\n"
			+ "		WHEN COUNT(soh.SalesOrderID) >= 5\r\n"
			+ "		AND MAX(sod.OrderQty) >= 10\r\n"
			+ "THEN 'PremiumCustomer'\r\n"
			+ "		WHEN COUNT(soh.SalesOrderID) >= 3\r\n"
			+ "THEN 'PreferredCustomer'\r\n"
			+ "		ELSE 'RegularCustomer'\r\n"
			+ "	END AS customerType\r\n"
			+ "FROM\r\n"
			+ "	Customer c\r\n"
			+ "INNER JOIN Person p ON\r\n"
			+ "	c.PersonID = p.BusinessEntityID\r\n"
			+ "LEFT JOIN SalesOrderHeader soh ON\r\n"
			+ "	c.CustomerID = soh.CustomerID\r\n"
			+ "LEFT JOIN SalesOrderDetail sod ON\r\n"
			+ "	soh.SalesOrderID = sod.SalesOrderID\r\n"
			+ "GROUP BY\r\n"
			+ "	c.CustomerID,\r\n"
			+ "	c.AccountNumber; \r\n"
, nativeQuery = true)
	List<CustomerSummaryManyProcProjection>  getCustomerSummaryManyProc();
}
