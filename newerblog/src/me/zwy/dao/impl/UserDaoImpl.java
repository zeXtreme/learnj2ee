package me.zwy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.zwy.dao.UserDao;
import me.zwy.util.DBConnection;
import me.zwy.vo.User;

public class UserDaoImpl implements UserDao {

	static Connection conn = DBConnection.getConnection();
	public boolean createUser(String userName, String passWord) {
		String sql = "insert into nb_user values(nb_user_id.nextval,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, passWord);
			int n = pst.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editUser(String id, String userName, String passWord) {
		// TODO Auto-generated method stub
		return false;
	}

	public User findById(String id) {
		User user = null;
		String sql = "select * from nb_user where id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				user = new User(rs.getString("id"), rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User findByUserName(String userName) {
		User user = null;
		String sql = "select * from nb_user where username=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				user = new User(rs.getString("id"), rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
