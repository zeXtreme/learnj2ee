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
public class Register extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("GB2312");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>index</title></head>");
		out.print("<body>");
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		String retypePassWord = req.getParameter("retype");
		UserDao ud = new UserDaoImpl();
		if(!(userName.matches("[A-Za-z0-9]{1}\\w{2,19}"))){
			out.print("<p>�û���������Ҫ�󣡣���");
		}else if(!(passWord.equals(retypePassWord))){
			out.print("<p>������������벻һ��������");
		}else if(!(passWord.matches("[A-Za-z0-9]{6,20}"))){
			out.print("<p>���벻����Ҫ�󣡣���");
		}else{
			if(ud.addUser(userName, passWord)){
				out.print("<p>ע��ɹ�������");
			}else{
				out.print("<p>ע��ʧ�ܣ��뻻���û������ԣ�����");
			}
		}
		out.print("</body>");
		out.print("</html>");
	}
	
}
