package com.souvik.org.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souvik.org.dao.OrderDao;
import com.souvik.org.exception.OrderServiceException;
import com.souvik.org.model.Order;

@Service
public class OrderService {

	@Autowired
	OrderDao dao;

	@PostConstruct
	public void addOrderDB() {
		List<Order> orders = Arrays.asList(new Order(1, "mobile", "electronics", 75699.0),
				new Order(2, "rice", "groccery", 75.0));
		dao.saveAll(orders);
	}

	public double getPrice(String productName) throws OrderServiceException {
		Order order = null;
		double amount = 0;
		try {
			order = dao.findByName(productName);
			amount = order.getAmount();
		} catch (NullPointerException ex) {
			throw new OrderServiceException("Order not found with product :"+ productName);
		}
		return amount;
	}
}
