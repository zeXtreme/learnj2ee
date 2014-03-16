package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldServlet implements Servlet {

	@Override
	public void destroy() {
		System.out.println("destroy...");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init...");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>99³Ë·¨±í</title></head>");
		out.print("<body>");
		out.print("<table border=1>");
		for(int i=1;i<10;i++){
			out.print("<tr>");
			for(int j=1;j<=i;j++){
				out.print("<td>" + j + "*" + i + "=" + j*i + "</td>");
			}
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("<hr>");
		out.print("<form action='login.do' method='get'><input type='text' name='name'><input type='submit'></form>");
		out.print("</body>");
		out.print("</html>");
		out.flush();
		out.close();
	}

}
