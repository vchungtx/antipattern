package com.example.chattyio.projection;

public interface CustomerSummaryManyProcProjection {
	
	Long getCustomerID();
	String getAccountNumber();
	String getFullName();
	Long getTotalOrders();
	String getCustomerType();

}
