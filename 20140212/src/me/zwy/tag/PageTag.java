package me.zwy.tag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import me.zwy.util.DBConnection;

public class PageTag implements Tag {
	
	private String tableName;
	private int pagesize;
	
	private PageContext pc;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	@Override
	public void setPageContext(PageContext pc) {
		this.pc = pc;
	}

	@Override
	public void setParent(Tag t) {

	}

	@Override
	public Tag getParent() {
		return null;
	}

	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pc.getOut();
		HttpServletRequest request = (HttpServletRequest) pc.getRequest();
		String page = request.getParameter("page");
		String path = request.getRequestURI() + "?page=";
		int p;
		if(page==null){
			p = 1;
		}else{
			p = Integer.parseInt(page);
		}
		String sql = "select * from (select rownum rn," + tableName + ".* from " + tableName + ") where rn between ? and ?";
		Connection conn = DBConnection.getConnection();
		try {
			int count = 0;
			ResultSet countSet = conn.createStatement().executeQuery("select count(*) from " + tableName);
			if(countSet.next()){
				count = countSet.getInt(1);
			}
			int maxPage = count % pagesize == 0 ? count/pagesize : (count - (count % pagesize))/pagesize + 1;
			if(p>maxPage){
				p = maxPage;
			}else if(p<1){
				p = 1;
			}
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, 1+pagesize*(p-1));
			pst.setInt(2, pagesize+pagesize*(p-1));
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			out.append("<table align='center' border='1'>");
			out.append("<tr>");
			for(int i=2;i<=rsmd.getColumnCount();i++){
				out.append("<th>");
				out.append(rsmd.getColumnName(i));
				out.append("</th>");
			}
			out.append("</tr>");
			while(rs.next()){
				out.append("<tr>");
				for(int i=2;i<=rsmd.getColumnCount();i++){
					out.append("<td>");
					out.append(rs.getString(i));
					out.append("</td>");
				}
				out.append("</tr>");
			}
			out.append("<tr>");
			out.append("<td align='center' colspan='" + rsmd.getColumnCount() + "'>");
			out.append("<a href='" + path + (p-1) + "'>上一页</a>  <a href='" + path + (p+1) + "'>下一页</a>");
			out.append("</td>");
			out.append("</tr>");
			out.append("</table>");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public void release() {

	}

}
