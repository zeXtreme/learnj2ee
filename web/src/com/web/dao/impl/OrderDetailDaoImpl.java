package com.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.dao.OrderDetailDao;
import com.web.util.DBConnection;
import com.web.vo.OrderDetail;

public class OrderDetailDaoImpl implements OrderDetailDao {
	
	private static Connection conn = DBConnection.getConnection();

	public boolean addOrderDetail(OrderDetail orderDetail) {
		String sql = "insert into Web_orderdetail values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderDetail.getOid());
			ps.setInt(2, orderDetail.getGid());
			ps.setInt(3, orderDetail.getGnum());
			int n = ps.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteOrderDetail(int oid) {
		String sql = "delete Web_orderdetail where oid=?";
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

	public List<OrderDetail> findByOid(int oid) {
		String sql = "select * from Web_orderdetail where oid=?";
		List<OrderDetail> list = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, oid);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<OrderDetail>();
			while(rs.next()){
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOid(rs.getInt(1));
				orderDetail.setGid(rs.getInt(2));
				orderDetail.setGnum(rs.getInt(3));
				list.add(orderDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
