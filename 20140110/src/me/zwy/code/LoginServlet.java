package me.zwy.code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String name = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		if(request.getParameter("exit") != null){
			request.getSession().invalidate();
			response.sendRedirect("login.html");
		}
		if(name == null || pwd == null){
			out.print("<script>alert('�û��������벻��Ϊ��')</script>");
		}else{
			if(name.equals("admin") && pwd.equals("root")){
				out.print("��ӭ����" + name + "�ĵ�����");
				out.print("<br>2�����ת...");
				request.getSession().setAttribute("user", name);
				response.setHeader("refresh", "2;url=index.jsp");
			}else{
				out.print("<script>alert('�û������������')</script>");
				response.setHeader("refresh", "0;url=login.html");
			}
		}
		out.flush();
		out.close();
	}

}
