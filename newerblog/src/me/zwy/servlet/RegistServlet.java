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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		UserDao ud = new UserDaoImpl();
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String rePassWord = request.getParameter("rePassWord");
		if(!passWord.equals(rePassWord)){
			out.print("<script>alert('两次输入密码不一致');</script>");
			response.setHeader("refresh", "0;url=regist.jsp");
		}else if(ud.findByUserName(userName)!=null){
			out.print("<script>alert('用户名已存在');</script>");
			response.setHeader("refresh", "0;url=regist.jsp");
		}else if(ud.createUser(userName, passWord)){
			out.print("<script>alert('注册成功');</script>");
			request.getSession().setAttribute("user", ud.findByUserName(userName));
			response.setHeader("refresh", "0;url=userPage.jsp");
		}else{
			out.print("<script>alert('注册失败');</script>");
			response.setHeader("refresh", "0;url=regist.jsp");
		}
		out.flush();
		out.close();
	}

}
