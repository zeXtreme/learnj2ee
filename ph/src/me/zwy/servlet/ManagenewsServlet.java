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
public class ManagenewsServlet extends HttpServlet {

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
		String delete = request.getParameter("delete");
		if(delete == null){
			request.getRequestDispatcher("admin/alternews.jsp").forward(request, response);
		}else{
			try {
				String sql = "delete news where id=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, delete);
				int n = ps.executeUpdate();
				if(n>0){
					out.print("<script>alert('É¾³ý³É¹¦');</script>");
					response.setHeader("refresh", "0;url=admin/managenews.jsp");
				}else{
					out.print("<script>alert('É¾³ýÊ§°Ü')</script>");
					response.setHeader("refresh", "0;url=admin/managenews.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		out.flush();
		out.close();
	}

}
