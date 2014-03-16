package com.web.dao;

import java.util.List;

import com.web.vo.OrderDetail;

public interface OrderDetailDao {

	public boolean addOrderDetail(OrderDetail orderDetail);
	public boolean deleteOrderDetail(int oid);
	public List<OrderDetail> findByOid(int oid);
	
}
