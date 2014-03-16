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

public class Index {
	
	public List<Content> getContents(User user){
		List<Content> list = null;
		Connection conn = DBConnection.getConnection();
		try {
			String sql = "select pid from mb_content where userid in (select fid from mb_follow where userid=?) order by cdate desc";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			ResultSet rs = pst.executeQuery();
			ContentDao cd = new ContentDaoImpl();
			list = new ArrayList<Content>();
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
