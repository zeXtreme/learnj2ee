package me.zwy.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import me.zwy.dao.UserDao;
import me.zwy.pojo.User;
import me.zwy.util.DBConnection;

public class UserDaoImpl implements UserDao {

	Connection conn = DBConnection.getConnection();
	@Override
	public boolean addUser(String userName,String passWord) {
		boolean flag = false;
		try {
			Statement st = conn.createStatement();
			int n = st.executeUpdate("INSERT INTO USERS VALUES('" + userName + "','" + passWord + "')");
			if(n > 0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public User findByUserName(String userName) {
		User u = null;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM USERS WHERE USERNAME='" + userName +"'");
			if(rs.next()){
				u = new User(userName, rs.getString("PASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

}
