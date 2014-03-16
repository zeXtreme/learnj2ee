package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.dao.UserDao;
import me.zwy.dao.impl.UserDaoImpl;
import me.zwy.pojo.User;

@SuppressWarnings("serial")
public class Login extends HttpServlet {

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
		UserDao ud = new UserDaoImpl();
		User u = ud.findByUserName(userName);
		if(u == null){
			out.print("<p>û������û�������");
		}else if(!(u.getPassWord().equals(passWord))){
			out.print("<p>���벻��ȷ������");
		}else{
			out.print("<p>��½�ɹ�������");
		}
		out.print("</body>");
		out.print("</html>");
	}
	
}
