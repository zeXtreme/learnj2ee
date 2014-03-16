package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.dao.UserDao;
import me.zwy.dao.impl.UserDaoImpl;

@SuppressWarnings("serial")
public class RegistServlet extends HttpServlet {

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
		String retype = request.getParameter("retype");
		if(!passWord.equals(retype)){
			out.print("<script>alert('两次输入的密码不一致！');</script>");
			response.setHeader("refresh", "0;url=regist.jsp");
		}
		UserDao ud = new UserDaoImpl();
		if(!ud.addUser(userName, passWord)){
			out.print("<script>alert('注册失败！');</script>");
			response.setHeader("refresh", "0;url=regist.jsp");
		}else{
			request.getSession().setAttribute("user", ud.findUser(userName));
			response.sendRedirect("index.jsp");
		}
		out.flush();
		out.close();
	}

}
