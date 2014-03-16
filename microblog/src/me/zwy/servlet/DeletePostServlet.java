package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.dao.ContentDao;
import me.zwy.dao.impl.ContentDaoImpl;

@SuppressWarnings("serial")
public class DeletePostServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String pid = request.getParameter("pid");
		ContentDao cd = new ContentDaoImpl();
		if(!cd.deleteContent(cd.findContent(Integer.parseInt(pid)))){
			out.print("<script>alert('É¾³ýÊ§°Ü£¡');</script>");
			response.setHeader("refresh", "0;url=mypost.jsp");
		}else{
			out.print("<script>alert('É¾³ý³É¹¦£¡');</script>");
			response.setHeader("refresh", "0;url=mypost.jsp");
		}
		out.flush();
		out.close();
	}

}
