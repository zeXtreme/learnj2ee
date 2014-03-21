package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.dao.UserDao;
import me.zwy.dao.impl.UserDaoImpl;
import me.zwy.vo.User;

public class LoginServlet extends HttpServlet {

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
		String userName = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setUserName(userName);
		user.setPassWord(pwd);
		UserDao ud = new UserDaoImpl();
		if(ud.isLogin(user)){
			request.getSession().setAttribute("user", user);
			response.sendRedirect("myjsp.jsp");
		}
		out.flush();
		out.close();
	}

}
