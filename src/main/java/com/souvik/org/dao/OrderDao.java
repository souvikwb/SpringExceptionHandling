package com.souvik.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.souvik.org.model.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

	Order findByName(String productName);

}
