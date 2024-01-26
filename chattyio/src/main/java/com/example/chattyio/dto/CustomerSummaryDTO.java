package com.example.chattyio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerSummaryDTO {
	Long customerID;

	String accountNumber;

	String fullName;

	Long TotalOrders;

	String CustomerType;
}
