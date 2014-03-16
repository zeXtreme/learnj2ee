package me.zwy.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.zwy.dao.ContentDao;
import me.zwy.dao.impl.ContentDaoImpl;
import me.zwy.util.DBConnection;

public class MyPost {
	
	public List<Content> getContents(User user){
		List<Content> list = null;
		Connection conn = DBConnection.getConnection();
		try {
			String sql = "select pid from mb_content where userid=? order by cdate desc";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<Content>();
			ContentDao cd = new ContentDaoImpl();
			while(rs.next()){
				Content content = cd.findContent(rs.getInt(1));
				list.add(content);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
