package me.zwy.servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ReadTxt implements Servlet {

	@Override
	public void destroy() {

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
	public void init(ServletConfig conf) throws ServletException {

	}

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/test.txt")));
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Ω‚ŒˆTXT</title></head><body>");
		String str = null;
		while((str = br.readLine()) != null){
			out.print("<p>" + str + "<br>");
		}
		out.print("</body></html>");
		out.flush();
		br.close();
		out.close();
	}

}
