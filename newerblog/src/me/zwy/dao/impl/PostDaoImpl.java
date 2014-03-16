package me.zwy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.zwy.dao.PostDao;
import me.zwy.util.DBConnection;
import me.zwy.vo.Post;

public class PostDaoImpl implements PostDao {

	static Connection conn = DBConnection.getConnection();
	public boolean createPost(String title, String context, String author_id) {
		String sql = "insert into nb_post values(nb_post_id.nextval,?,?,?,sysdate)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, title);
			pst.setString(2, context);
			pst.setString(3, author_id);
			int n = pst.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletePost(String id) {
		String sql = "delete nb_post where id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			int n = pst.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean editPost(String id, String title, String context) {
		String sql = "update nb_post set title=?,context=?,postdate=sysdate where id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, title);
			pst.setString(2, context);
			pst.setString(3, id);
			int n = pst.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Post findById(String id) {
		Post post = null;
		String sql = "select * from nb_post where id=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				post = new Post(rs.getString("id"), rs.getString("title"), rs.getString("context"),rs.getString("author_id"),rs.getDate("postdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}

}
