package me.zwy.code;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.vo.Contact;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	static Vector<Contact> cs = null;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String pid = request.getParameter("pid");
		if (pid != null) {
			cs.remove(Integer.parseInt(pid));
		} else {
			cs = DataBaseModel.getContacts();
		}
		out.print("当前操作员：" + name);
		out.print("<table border='1' width='600'>");
		out.print("<caption>所有联系人列表</caption>");
		out.print("<tr><th>姓名</th><th>电话</th><th>E-mail</th><th>住址</th><th>备注</th></tr>");
		for (int i = 0; i < cs.size(); i++) {
			out.print("<tr>");
			out.print(cs.get(i) + "<td><a href='login?pid=" + i + "&name="
					+ name + "'>删除</a></td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.flush();
		out.close();
	}

}
