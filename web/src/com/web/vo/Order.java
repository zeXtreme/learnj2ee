package com.web.vo;

import java.util.Date;
import java.util.List;

import com.web.dao.OrderDetailDao;
import com.web.dao.impl.OrderDetailDaoImpl;

public class Order {

	private int oid;
	private int userId;
	private Date odate;
	private String comment;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getOdate() {
		return odate;
	}
	public void setOdate(Date odate) {
		this.odate = odate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public double getTotalPrice(){
		return 0.0;
	}
	public List<OrderDetail> getOrderdetail(){
		List<OrderDetail> list = null;
		OrderDetailDao odd = new OrderDetailDaoImpl();
		list = odd.findByOid(this.oid);
		return list;
	}
	
}
