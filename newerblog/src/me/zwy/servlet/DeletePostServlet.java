package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.dao.PostDao;
import me.zwy.dao.impl.PostDaoImpl;

@SuppressWarnings("serial")
public class DeletePostServlet extends HttpServlet {

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
		String id = request.getParameter("pid");
		if(pd.deletePost(id)){
			out.print("<script>alert('ɾ���ɹ�');</script>");
			response.setHeader("refresh", "0;url=admin/mngrPost.jsp");
		}else{
			out.print("<script>alert('ɾ��ʧ��');</script>");
			response.setHeader("refresh", "0;url=admin/mngrPost.jsp");
		}
		out.flush();
		out.close();
	}

}
