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
public class SetPwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String oldPwd = request.getParameter("oldpwd");
		String newPwd = request.getParameter("newpwd");
		String retype = request.getParameter("retype");
		User user = (User) request.getSession().getAttribute("user");
		UserDao ud = new UserDaoImpl();
		if(!user.getPassWord().equals(oldPwd)){
			out.print("<script>alert('原密码输入错误！');</script>");
			response.setHeader("refresh", "0;url=changepwd.jsp");
		}else if(!newPwd.equals(retype)){
			out.print("<script>alert('两次输入的密码不一致！');</script>");
			response.setHeader("refresh", "0;url=changepwd.jsp");
		}else if(!ud.setPassWord(user, newPwd)){
			out.print("<script>alert('修改失败！');</script>");
			response.setHeader("refresh", "0;url=changepwd.jsp");
		}else{
			out.print("<script>alert('修改成功！');</script>");
			response.setHeader("refresh", "0;url=changepwd.jsp");
		}
		out.flush();
		out.close();
	}

}
