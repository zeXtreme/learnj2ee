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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(request.getParameter("exit")!=null){
			request.getSession().invalidate();
			response.sendRedirect("index.jsp");
		}
		UserDao ud = new UserDaoImpl();
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		User user = ud.findByUserName(userName);
		if(user==null){
			out.print("<script>alert('没有此用户');</script>");
			response.setHeader("refresh", "0;url=index.jsp");
		}else if(!user.getPassWord().equals(passWord)){
			out.print("<script>alert('用户名或密码错误');</script>");
			response.setHeader("refresh", "0;url=index.jsp");
		}else{
			request.getSession().setAttribute("user", user);
			response.setHeader("refresh", "0;url=userPage.jsp");
		}
		out.flush();
		out.close();
	}

}
