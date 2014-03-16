package me.zwy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.zwy.dao.ContentDao;
import me.zwy.util.DBConnection;
import me.zwy.vo.Content;

public class ContentDaoImpl implements ContentDao {
	
	private static Connection conn = DBConnection.getConnection();

	@Override
	public boolean addContent(int userId,String content) {
		try {
			String sql = "insert into mb_content values(mb_seq_post.nextval,?,?,sysdate)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setString(2, content);
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
	public boolean deleteContent(Content content) {
		try {
			String sql1 = "delete mb_comment where pid=?";
			String sql2 = "delete mb_content where pid=?";
			PreparedStatement pst = conn.prepareStatement(sql1);
			pst.setInt(1, content.getPid());
			pst.executeUpdate();
			pst = conn.prepareStatement(sql2);
			pst.setInt(1, content.getPid());
			int n2 = pst.executeUpdate();
			if(n2>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean setContent(Content content, String newContent) {
		try {
			String sql = "update mb_content set content=? where pid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, newContent);
			pst.setInt(2, content.getPid());
			int n = pst.executeUpdate();
			if(n>0){
				content.setContent(newContent);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Content findContent(int pid) {
		Content content = null;
		try {
			String sql = "select * from mb_content where pid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				content = new Content();
				content.setPid(rs.getInt(1));
				content.setUserId(rs.getInt(2));
				content.setContent(rs.getString(3));
				content.setCdate(rs.getDate(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return content;
	}

}
