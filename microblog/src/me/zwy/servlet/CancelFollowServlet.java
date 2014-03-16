package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.dao.FollowDao;
import me.zwy.dao.UserDao;
import me.zwy.dao.impl.FollowDaoImpl;
import me.zwy.dao.impl.UserDaoImpl;
import me.zwy.vo.User;

@SuppressWarnings("serial")
public class CancelFollowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int userId = Integer.parseInt(request.getParameter("userid"));
		FollowDao fd = new FollowDaoImpl();
		UserDao ud = new UserDaoImpl();
		User user = (User) request.getSession().getAttribute("user");
		if(!fd.cancelFollow(user, ud.findById(userId))){
			out.print("<script>alert('É¾³ýÊ§°Ü£¡');</script>");
			response.setHeader("refresh", "0;url=user.jsp?follow=1");
		}else{
			out.print("<script>alert('É¾³ý³É¹¦£¡');</script>");
			response.setHeader("refresh", "0;url=user.jsp?follow=1");
		}
		out.flush();
		out.close();
	}

}
