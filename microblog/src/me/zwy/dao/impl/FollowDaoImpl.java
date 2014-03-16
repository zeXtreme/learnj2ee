package me.zwy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import me.zwy.dao.FollowDao;
import me.zwy.util.DBConnection;
import me.zwy.vo.User;

public class FollowDaoImpl implements FollowDao {
	
	private static Connection conn = DBConnection.getConnection();

	@Override
	public boolean addFollow(User fans, User follow) {
		try {
			String sql = "insert into mb_follow values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, fans.getUserId());
			pst.setInt(2, follow.getUserId());
			int n = pst.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean cancelFollow(User fans, User follow) {
		try {
			String sql = "delete mb_follow where userid=? and fid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, fans.getUserId());
			pst.setInt(2, follow.getUserId());
			int n = pst.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeFans(User follow, User fans) {
		try {
			String sql = "delete mb_follow where fid=? and userid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, follow.getUserId());
			pst.setInt(2, fans.getUserId());
			int n = pst.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
