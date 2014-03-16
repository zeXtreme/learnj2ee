package me.zwy.work;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.util.DBConnection;

@SuppressWarnings("serial")
public class FlipPage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM (SELECT rownum rn,t.* FROM emp t) WHERE rn>=? AND rn <=?");//����Ԥ����Statement
			int x = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
			ResultSet maxpage = conn.createStatement().executeQuery("SELECT COUNT(*) FROM EMP");
			int max = 0;
			if(maxpage.next()){
				max = maxpage.getInt(1)%5 == 0 ? maxpage.getInt(1)/5 : maxpage.getInt(1)/5+1;
			}
			ps.setInt(1, 1 + 5*(x-1));
			ps.setInt(2, 5 + 5*(x-1));
			out.print("<html><head><title>Flippage</title></head><body>");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsd = rs.getMetaData();
			out.print("<table border='1' align='center' width='800'><tr>");
			for(int i=2;i<=rsd.getColumnCount();i++){
				out.print("<th>" + rsd.getColumnName(i) + "</th>");
			}
			out.print("</tr>");
			while(rs.next()){
				out.print("<tr>");
				for(int i=2;i<=rsd.getColumnCount();i++){
					out.print("<td>" + rs.getString(i) + "</td>");
				}
				out.print("</tr>");
			}
			String path = req.getRequestURI() + "?page=";
			out.print("<tr>");
			out.print("<td colspan='8' align='center'>");
			if(x == 1){
				out.print("�Ѿ��ǵ�һҳ&nbsp&nbsp");
			}else{
				out.print("<a href='" + path + 1 + "'>��һҳ</a>&nbsp&nbsp");
				out.print("<a href='" + path + ((x-1)>0 ? (x-1) : 1) + "'>��һҳ</a>&nbsp&nbsp");
			}
			for(int i=1;i<=max;i++){
				out.print("<a href='" + path + i + "'>" + i + "</a>&nbsp&nbsp");
			}
			if(x == max){
				out.print("�Ѿ������һҳ&nbsp&nbspҳ�룺" + x +"&nbsp&nbsp");
			}else{
				out.print("<a href='" + path + ((x+1)<=max ? (x+1) : max) + "'>��һҳ</a>&nbsp&nbspҳ�룺" + x +"&nbsp&nbsp");
				out.print("<a href='" + path + max + "'>���һҳ</a>");
			}
			out.print("</td></tr>");
			out.print("</table>");
			out.print("</body></html>");
			out.flush();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
