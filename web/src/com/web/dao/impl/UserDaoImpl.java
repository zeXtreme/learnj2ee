package com.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.dao.UserDao;
import com.web.util.DBConnection;
import com.web.vo.User;

public class UserDaoImpl implements UserDao {

	private static Connection conn = DBConnection.getConnection();
	
	public boolean addUser(User user) {
		String sql = "insert into Web_user values(SEQ_WEB_USERID.nextval,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			ps.setString(3, user.getName());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getTel());
			int n = ps.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changeUser(int userId, User newUser) {
		String sql = "update Web_user set name=?,address=?,tel=? where userid=" + userId;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newUser.getName());
			ps.setString(2, newUser.getAddress());
			ps.setString(3, newUser.getTel());
			int n = ps.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public User findById(int userId) {
		String sql = "select * from Web_user where userid=?";
		User user = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassWord(rs.getString(3));
				user.setName(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setTel(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User findByUserName(String userName) {
		String sql = "select * from Web_user where username=?";
		User user = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassWord(rs.getString(3));
				user.setName(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setTel(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
