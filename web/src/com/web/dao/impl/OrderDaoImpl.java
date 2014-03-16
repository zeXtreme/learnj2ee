package com.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.dao.OrderDao;
import com.web.util.DBConnection;
import com.web.vo.Order;

public class OrderDaoImpl implements OrderDao {
	
	private static Connection conn = DBConnection.getConnection();

	public boolean addOrder(Order order) {
		String sql = "insert into Web_order values(SEQ_WEB_OID.nextval,?,sysdate,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, order.getUserId());
			ps.setString(2, order.getComment());
			int n = ps.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteOrder(int oid) {
		String sql = "delete Web_order where oid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, oid);
			int n = ps.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Order> findByUserId(int userId) {
		String sql = "select * from Web_order where userid=?";
		List<Order> list = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<Order>();
			while(rs.next()){
				Order order = new Order();
				order.setOid(rs.getInt(1));
				order.setUserId(rs.getInt(2));
				order.setOdate(rs.getDate(3));
				order.setComment(rs.getString(4));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Order findById(int id) {
		String sql = "select * from Web_order where oid=?";
		Order order = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				order = new Order();
				order.setOid(rs.getInt(1));
				order.setUserId(rs.getInt(2));
				order.setOdate(rs.getDate(3));
				order.setComment(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

}
