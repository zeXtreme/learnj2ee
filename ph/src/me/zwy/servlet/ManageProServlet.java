package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.util.DBConnection;

@SuppressWarnings("serial")
public class ManageProServlet extends HttpServlet {

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
		if(request.getParameter("alter")!=null){
			request.getRequestDispatcher("admin/alterpro.jsp").forward(request, response);
		}else{
			String id = request.getParameter("delete");
			String sql = "delete product where pid=" + id;
			try {
				Statement st = conn.createStatement();
				int n = st.executeUpdate(sql);
				if(n>0){
					out.print("<script>alert('É¾³ý³É¹¦');</script>");
					response.setHeader("refresh", "0;url=admin/managepro.jsp");
				}else{
					out.print("<script>alert('É¾³ýÊ§°Ü');</script>");
					response.setHeader("refresh", "0;url=admin/managepro.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		out.flush();
		out.close();
	}

}
