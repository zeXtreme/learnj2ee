package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.dao.FollowDao;
import me.zwy.dao.UserDao;
import me.zwy.dao.impl.FollowDaoImpl;
import me.zwy.dao.impl.UserDaoImpl;
import me.zwy.vo.User;

@SuppressWarnings("serial")
public class FollowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		User user = (User) request.getSession().getAttribute("user");
		int userId = Integer.parseInt(request.getParameter("userid"));
		for(User u : user.getFollows()){
			if(u.getUserId()==userId){
				out.print("<script>alert('你已经关注过此用户！');</script>");
				response.setHeader("refresh", "0;url=userinfo.jsp?userid=" + userId);
				break;
			}
		}
		FollowDao fd = new FollowDaoImpl();
		UserDao ud = new UserDaoImpl();
		if(!fd.addFollow(user, ud.findById(userId))){
			out.print("<script>alert('添加关注失败！');</script>");
			response.setHeader("refresh", "0;url=userinfo.jsp?userid=" + userId);
		}else{
			out.print("<script>alert('添加关注成功！');</script>");
			response.setHeader("refresh", "0;url=userinfo.jsp?userid=" + userId);
		}
		out.flush();
		out.close();
	}

}
