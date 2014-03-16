package me.zwy.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.zwy.dao.UserDao;
import me.zwy.dao.impl.UserDaoImpl;
import me.zwy.util.DBConnection;

public class Content {
	
	private int pid;
	private int userId;
	private String content;
	private Date cdate;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public List<Comment> getComment(){
		List<Comment> list = null;
		Connection conn = DBConnection.getConnection();
		try {
			String sql = "select * from mb_comment where pid=? order by cid desc";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, this.pid);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<Comment>();
			while(rs.next()){
				Comment comm = new Comment();
				comm.setCid(rs.getInt(1));
				comm.setPid(rs.getInt(2));
				comm.setUserId(rs.getInt(3));
				comm.setContent(rs.getString(4));
				list.add(comm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public User getUser(){
		User user = null;
		UserDao ud = new UserDaoImpl();
		user = ud.findById(this.userId);
		return user;
	}

}
