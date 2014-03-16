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

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		UserDao ud = new UserDaoImpl();
		User user = ud.findUser(userName);
		if(user==null){
			out.print("<script>alert('没有此用户！');</script>");
			response.setHeader("refresh", "0;url=login.jsp");
		}else if(!user.getPassWord().equals(passWord)){
			out.print("<script>alert('用户或密码不正确！');</script>");
			response.setHeader("refresh", "0;url=login.jsp");
		}else{
			request.getSession().setAttribute("user", user);
			response.sendRedirect("index.jsp");
		}
		out.flush();
		out.close();
	}

}
