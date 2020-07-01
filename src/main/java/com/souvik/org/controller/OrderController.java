package com.souvik.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.souvik.org.exception.OrderServiceException;
import com.souvik.org.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService service;
	
	@GetMapping("/orderPrice/{productName}")
	public String getOrderPrice(@PathVariable String productName) throws OrderServiceException {
		double amount = service.getPrice(productName);
		return "the price of the product "+ productName + " " +  amount;
	}
}
