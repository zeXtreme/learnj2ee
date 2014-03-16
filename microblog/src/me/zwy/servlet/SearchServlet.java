package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.dao.UserDao;
import me.zwy.dao.impl.UserDaoImpl;
import me.zwy.util.DBConnection;
import me.zwy.vo.User;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Connection conn = DBConnection.getConnection();
		UserDao ud = new UserDaoImpl();
		String user = request.getParameter("user");
		try {
			PreparedStatement pst = conn.prepareStatement("select userid from mb_user where username like ?");
			pst.setString(1, "%" + user + "%");
			ResultSet rs = pst.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()){
				list.add(ud.findById(rs.getInt(1)));
			}
			request.setAttribute("users", list);
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

}
