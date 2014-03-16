package com.web.dao;

import java.util.List;

import com.web.vo.Order;

public interface OrderDao {

	public boolean addOrder(Order order);
	public boolean deleteOrder(int oid);
	public List<Order> findByUserId(int userId);
	public Order findById(int id);
	
}
