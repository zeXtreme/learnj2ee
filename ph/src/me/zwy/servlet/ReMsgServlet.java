package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.util.DBConnection;

@SuppressWarnings("serial")
public class ReMsgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.getConnection();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		String sql = "insert into revertmsg values(remsg_id.nextval,?,?,?,?,sysdate)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, title);
			ps.setString(3, context);
			ps.setString(4, name);
			int n = ps.executeUpdate();
			if(n>0){
				out.print("<script>alert('添加成功');</script>");
				response.setHeader("refresh", "0;url=revertmsg.jsp?msg="+id);
			}else{
				out.print("<script>alert('添加失败');</script>");
				response.setHeader("refresh", "0;url=revertmsg.jsp?msg="+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

}
