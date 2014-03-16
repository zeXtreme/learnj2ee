package me.zwy.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.zwy.dao.UserDao;
import me.zwy.dao.impl.UserDaoImpl;
import me.zwy.util.DBConnection;

public class User {
	
	private int userId;
	private String userName;
	private String passWord;
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
	public List<User> getFollows(){
		List<User> list = null;
		Connection conn = DBConnection.getConnection();
		UserDao ud = new UserDaoImpl();
		try {
			String sql = "select fid from mb_follow where userid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, this.userId);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<User>();
			while(rs.next()){
				int userid = rs.getInt(1);
				if(userid==this.userId){
					continue;
				}
				list.add(ud.findById(userid));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<User> getFans(){
		List<User> list = null;
		Connection conn = DBConnection.getConnection();
		UserDao ud = new UserDaoImpl();
		try {
			String sql = "select userid from mb_follow where fid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, this.userId);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<User>();
			while(rs.next()){
				int fid = rs.getInt(1);
				if(fid==this.userId){
					continue;
				}
				list.add(ud.findById(fid));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
