package com.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.dao.PostDao;
import com.web.util.DBConnection;
import com.web.vo.Post;

public class PostDaoImpl implements PostDao {
	
	private static Connection conn = DBConnection.getConnection();

	public boolean addPost(Post post) {
		String sql = "insert into Web_post values(SEQ_WEB_PID.nextval,?,?,sysdate)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, post.getTitle());
			ps.setString(2, post.getContent());
			int n = ps.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletePost(int pid) {
		String sql = "delete Web_post where pid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			int n = ps.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changePost(int pid, Post newPost) {
		String sql = "update Web_post set title=?,content=?,pdate=sysdate where pid=" + pid;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPost.getTitle());
			ps.setString(2, newPost.getContent());
			int n = ps.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Post findById(int pid) {
		String sql = "select * from Web_post where pid=?";
		Post post = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				post = new Post();
				post.setPid(rs.getInt(1));
				post.setTitle(rs.getString(2));
				post.setContent(rs.getString(3));
				post.setPdate(rs.getDate(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}

}
