package me.zwy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import me.zwy.dao.CommentDao;
import me.zwy.util.DBConnection;
import me.zwy.vo.Comment;

public class CommentDaoImpl implements CommentDao {
	
	private static Connection conn = DBConnection.getConnection();

	@Override
	public boolean addComment(int pid, int userId, String content) {
		try {
			String sql = "insert into mb_comment values(mb_seq_comm.nextval,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.setInt(2, userId);
			pst.setString(3, content);
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
	public boolean deleteComment(int cid) {
		try {
			String sql = "delete mb_comment where cid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
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
	public boolean setContent(Comment comment, String newContent) {
		try {
			String sql = "update mb_comment set content=? where cid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, newContent);
			pst.setInt(2, comment.getCid());
			int n = pst.executeUpdate();
			if(n>0){
				comment.setContent(newContent);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Comment findComment(int cid) {
		Comment comment = null;
		try {
			String sql = "select * from mb_comment where cid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				comment = new Comment();
				comment.setCid(rs.getInt(1));
				comment.setPid(rs.getInt(2));
				comment.setUserId(rs.getInt(3));
				comment.setContent(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comment;
	}

}
