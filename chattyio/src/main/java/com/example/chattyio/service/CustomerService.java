package com.example.chattyio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chattyio.dto.CustomerSummaryDTO;
import com.example.chattyio.projection.CustomerSummaryManyProcProjection;
import com.example.chattyio.projection.CustomerSummaryProjection;
import com.example.chattyio.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerSummaryDTO> getCustomerSummary() {
		List<CustomerSummaryProjection> customerSummaryList = customerRepository.getCustomerSummary();
		List<CustomerSummaryDTO> customerSummaryDTOs = new ArrayList<CustomerSummaryDTO>();
		for (CustomerSummaryProjection customerSummary : customerSummaryList) {
			Long customerId = customerSummary.getCustomerID();
			String accountNumber = customerSummary.getAccountNumber();
			String fullName = customerSummary.getTitle().concat(customerSummary.getFirstName()).concat(customerSummary.getLastName());
			Long salesOrderId = customerSummary.getSalesOrderID();
			Integer orderQty = customerSummary.getOrderQty();

			// Perform any additional logic or calculations here
			String customerType = calculateCustomerType(salesOrderId, Objects.nonNull(orderQty) ? orderQty : 0);
			
			customerSummaryDTOs.add(CustomerSummaryDTO.builder().customerID(customerId).accountNumber(accountNumber).fullName(fullName).CustomerType(customerType).build());

		}
	


		return customerSummaryDTOs;
	}

	private String calculateCustomerType(Long salesOrderId, Integer orderQty) {
		// Your logic to determine customer type based on sales order data
		if (orderQty >= 10) {
			return "PremiumCustomer";
		} else if (orderQty >= 5) {
			return "PreferredCustomer";
		} else {
			return "RegularCustomer";
		}
	}
	
	
	public List<CustomerSummaryDTO> getCustomerSummaryManyProc(){
		
		List<CustomerSummaryManyProcProjection> lst =  customerRepository.getCustomerSummaryManyProc();
		
		List<CustomerSummaryDTO> customerSummaryDTOs = new ArrayList<CustomerSummaryDTO>();
		for (CustomerSummaryManyProcProjection customerSummary : lst) {

			customerSummaryDTOs.add(CustomerSummaryDTO.builder().customerID(customerSummary.getCustomerID())
					.accountNumber(customerSummary.getAccountNumber())
					.fullName(customerSummary.getFullName())
					.TotalOrders(customerSummary.getTotalOrders())
					.CustomerType(customerSummary.getCustomerType()).build());

		}
		return customerSummaryDTOs;
	}
}
