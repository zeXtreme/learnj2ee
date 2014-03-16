package com.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.dao.GoodsDao;
import com.web.util.DBConnection;
import com.web.vo.Goods;

public class GoodsDaoImpl implements GoodsDao {
	
	private static Connection conn = DBConnection.getConnection();

	public boolean addGoods(Goods goods) {
		String sql = "insert into Web_goods values(SEQ_WEB_GID.nextval,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, goods.getGname());
			ps.setDouble(2, goods.getGprice());
			ps.setString(3, goods.getGdesc());
			ps.setString(4, goods.getGimage());
			int n = ps.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteGoods(int gid) {
		String sql = "delete Web_goods where gid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, gid);
			int n = ps.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changeGoods(int gid, Goods newGoods) {
		String sql = "update Web_goods set gname=?,gprice=?,gdesc=?,gimage=? where gid=" + gid;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newGoods.getGname());
			ps.setDouble(2, newGoods.getGprice());
			ps.setString(3, newGoods.getGdesc());
			ps.setString(4, newGoods.getGimage());
			int n = ps.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Goods findGoods(int gid) {
		String sql = "select * from Web_goods where gid=?";
		Goods goods = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, gid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				goods = new Goods();
				goods.setGid(rs.getInt(1));
				goods.setGname(rs.getString(2));
				goods.setGprice(rs.getDouble(3));
				goods.setGdesc(rs.getString(4));
				goods.setGimage(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;
	}

}
