package me.zwy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.zwy.dao.UserDao;
import me.zwy.vo.User;
import me.zwy.util.DBConnection;

public class UserDaoImpl implements UserDao {

	private static Connection conn = DBConnection.getConnection();
	@Override
	public boolean isLogin(User user) {
		String sql = "select * from users where username=? and password=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
