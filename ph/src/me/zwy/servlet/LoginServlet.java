package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.util.DBConnection;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

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
		if(request.getParameter("exit")!=null){
			request.getSession().invalidate();
			response.sendRedirect("admin/login.jsp");
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			PreparedStatement ps = conn.prepareStatement("select * from phusers where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				if(rs.getString("password").equals(password)){
					request.getSession().setAttribute("user", username);
					response.sendRedirect("admin/index.jsp");
				}else{
					out.print("<script>alert('用户名或密码错误！')</script>");
					response.setHeader("refresh", "0;url=admin/login.jsp");
				}
			}else{
				out.print("<script>alert('用户名或密码错误！')</script>");
				response.setHeader("refresh", "0;url=admin/login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

}
