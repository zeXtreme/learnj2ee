package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.dao.ContentDao;
import me.zwy.dao.impl.ContentDaoImpl;
import me.zwy.vo.User;

@SuppressWarnings("serial")
public class NewPostServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String content = request.getParameter("content");
		User user = (User) request.getSession().getAttribute("user");
		ContentDao cd = new ContentDaoImpl();
		if(!cd.addContent(user.getUserId(), content)){
			out.print("<script>alert('发表失败！')</script>");
			response.setHeader("refresh", "0;url=index.jsp");
		}else{
			out.print("<script>alert('发表成功！')</script>");
			response.setHeader("refresh", "0;url=index.jsp");
		}
		out.flush();
		out.close();
	}

}
