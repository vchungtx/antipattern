package com.example.chattyio.projection;

public interface CustomerSummaryProjection {
	Long getCustomerID();

	String getAccountNumber();

	String getTitle();

	String getFirstName();

	String getLastName();

	Long getSalesOrderID();

	Integer getOrderQty();
}
