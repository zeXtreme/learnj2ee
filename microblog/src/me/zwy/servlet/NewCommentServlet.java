package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.dao.CommentDao;
import me.zwy.dao.impl.CommentDaoImpl;
import me.zwy.vo.User;

@SuppressWarnings("serial")
public class NewCommentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String pid = request.getParameter("pid");
		String content = request.getParameter("comment");
		User user = (User) request.getSession().getAttribute("user");
		CommentDao cd = new CommentDaoImpl();
		if(!cd.addComment(Integer.parseInt(pid), user.getUserId(), content)){
			out.print("<script>alert('发表失败！')</script>");
			response.setHeader("refresh", "0;url=content.jsp?pid=" + pid);
		}else{
			out.print("<script>alert('发表成功！')</script>");
			response.setHeader("refresh", "0;url=content.jsp?pid=" + pid);
		}
		out.flush();
		out.close();
	}

}
