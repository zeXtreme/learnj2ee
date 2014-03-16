package me.zwy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.zwy.dao.UserDao;
import me.zwy.util.DBConnection;
import me.zwy.vo.User;

public class UserDaoImpl implements UserDao {
	
	private static Connection conn = DBConnection.getConnection();

	@Override
	public boolean addUser(String userName,String passWord) {
		try {
			String sql = "insert into mb_user values(mb_seq_userid.nextval,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, passWord);
			int n = pst.executeUpdate();
			if(n>0){
				conn.createStatement().executeUpdate("insert into mb_follow values(mb_seq_userid.currval,mb_seq_userid.currval)");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean setPassWord(User user, String newPwd) {
		try {
			String sql = "update mb_user set password=? where userid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setInt(2, user.getUserId());
			int n = pst.executeUpdate();
			if(n>0){
				user.setPassWord(newPwd);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User findUser(String userName) {
		User user = null;
		try {
			String sql = "select * from mb_user where username=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassWord(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User findById(int userId) {
		User user = null;
		try {
			String sql = "select * from mb_user where userid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassWord(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
