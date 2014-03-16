package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.vo.Employee;
import me.zwy.vo.Pager;

@SuppressWarnings("serial")
public class PageServlet extends HttpServlet {

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
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null){
			pageNum = "1";
		}
		Employee emp = new Employee();
		Pager pager = new Pager();
		pager.setList(emp.getEmployee(Integer.parseInt(pageNum)));
		pager.setTotal(emp.getTotal());
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		out.flush();
		out.close();
	}

}
