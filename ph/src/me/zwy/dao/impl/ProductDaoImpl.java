package me.zwy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import me.zwy.dao.ProductDao;
import me.zwy.util.DBConnection;
import me.zwy.vo.Product;

public class ProductDaoImpl implements ProductDao {

	static Connection conn = DBConnection.getConnection();
	@Override
	public List<Product> getAll() {
		List<Product> list = null;
		try {
			String sql = "select * from product";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			list = new ArrayList<Product>();
			while(rs.next()){
				Product pro = new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6));
				list.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product getById(String pid) {
		Product pro = null;
		try {
			String sql = "select * from product where pid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				pro = new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}

	@Override
	public boolean addProduct(Product pro) {
		try {
			String sql = "insert into product values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pro.getPid());
			ps.setString(2, pro.getPname());
			ps.setString(3, pro.getPbrand());
			ps.setString(4, pro.getPtype());
			ps.setString(5, pro.getPprice()+"");
			ps.setString(6, pro.getPimage());
			int n = ps.executeUpdate();
			if(n>0){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(String id) {
		try {
			String sql = "delete product where pid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int n = ps.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
