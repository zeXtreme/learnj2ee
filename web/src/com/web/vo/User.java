package com.web.vo;

import java.util.List;

import com.web.dao.OrderDao;
import com.web.dao.impl.OrderDaoImpl;

public class User {

	private int userId;
	private String userName;
	private String passWord;
	private String name;
	private String address;
	private String tel;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<Order> getOrder(){
		List<Order> list = null;
		OrderDao od = new OrderDaoImpl();
		list = od.findByUserId(this.userId);
		return list;
	}
	
}
