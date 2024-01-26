package com.example.chattyio.controller.busydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chattyio.service.CustomerService;

@RestController
@RequestMapping("/api/busy")
public class BusyDbController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/test")
	public ResponseEntity<?> getXXX(){
		return ResponseEntity.ok().body(customerService.getCustomerSummary());
		
	}
	
	@GetMapping("/test2")
	public ResponseEntity<?> getXXX2(){
		return ResponseEntity.ok().body(customerService.getCustomerSummaryManyProc());
		
	}
}
