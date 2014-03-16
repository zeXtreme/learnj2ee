package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.dao.PostDao;
import me.zwy.dao.impl.PostDaoImpl;
import me.zwy.vo.User;

@SuppressWarnings("serial")
public class AddPostServlet extends HttpServlet {

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
		PostDao pd = new PostDaoImpl();
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		User user = (User) request.getSession().getAttribute("user");
		if(pd.createPost(title, context, user.getId())){
			out.print("<script>alert('添加成功');</script>");
			response.setHeader("refresh", "0;url=admin/mngrPost.jsp");
		}else{
			out.print("<script>alert('添加失败');</script>");
			response.setHeader("refresh", "0;url=admin/mngrPost.jsp");
		}
		out.flush();
		out.close();
	}

}
