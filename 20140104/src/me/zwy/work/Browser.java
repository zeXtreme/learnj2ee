package me.zwy.work;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Browser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String UA = req.getHeader("User-Agent");
		System.out.println(UA);
		if(UA.contains("Firefox")){
			resp.sendRedirect("ff.jsp");
		}else if(UA.contains("Trident")){
			resp.sendRedirect("ie.jsp");
		}else{
			resp.sendRedirect("other.jsp");
		}
	}
	
}
