package me.zwy.code;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.OracleTypes;
import me.zwy.util.DBConnection;

@SuppressWarnings("serial")
public class FlipPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Connection conn = DBConnection.getConnection();
		int page = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
		try {
			out.print("<html><head><title>Flippage</title></head><body>");
			CallableStatement cs1 = conn.prepareCall("call pageflip.maxpage(?)");
			cs1.registerOutParameter(1, OracleTypes.NUMBER);
			cs1.execute();
			int max = cs1.getInt(1);
			CallableStatement cs2 = conn.prepareCall("call pageflip.page(?,?)");
			cs2.setInt(1, page);
			cs2.registerOutParameter(2, OracleTypes.CURSOR);
			cs2.execute();
			ResultSet rs = (ResultSet) cs2.getObject(2);
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
			String path = request.getRequestURI() + "?page=";
			out.print("<tr>");
			out.print("<td colspan='8' align='center'>");
			if(page == 1){
				out.print("已经是第一页&nbsp&nbsp");
			}else{
				out.print("<a href='" + path + 1 + "'>第一页</a>&nbsp&nbsp");
				out.print("<a href='" + path + ((page-1)>0 ? (page-1) : 1) + "'>上一页</a>&nbsp&nbsp");
			}
			for(int i=1;i<=max;i++){
				out.print("<a href='" + path + i + "'>" + i + "</a>&nbsp&nbsp");
			}
			if(page == max){
				out.print("已经是最后一页&nbsp&nbsp页码：" + page +"&nbsp&nbsp");
			}else{
				out.print("<a href='" + path + ((page+1)<=max ? (page+1) : max) + "'>下一页</a>&nbsp&nbsp页码：" + page +"&nbsp&nbsp");
				out.print("<a href='" + path + max + "'>最后一页</a>");
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
