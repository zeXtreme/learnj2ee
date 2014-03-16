package me.zwy.code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.util.LoginDaoImpl;

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
		String save = request.getParameter("save");
		if(new LoginDaoImpl().isLogin(name, pwd)){
			if(save != null){
				Cookie c = new Cookie(name, pwd);
				c.setMaxAge(120);
				response.addCookie(c);
			}
			request.getSession().setAttribute("user", name);
			out.print("<script>alert('µÇÂ½³É¹¦');</script>");
			response.setHeader("refresh", "2;url=index.jsp");
		}else{
			out.print("<script>alert('µÇÂ½Ê§°Ü');</script>");
			response.setHeader("refresh", "2;url=login.html");
		}
		out.flush();
		out.close();
	}

}
