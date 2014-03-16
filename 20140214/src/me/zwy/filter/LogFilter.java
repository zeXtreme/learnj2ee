package me.zwy.filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		FileWriter fw = new FileWriter(req.getRealPath("app.log"), true);
		PrintWriter out = new PrintWriter(fw);
		out.println("IP地址：" + request.getRemoteAddr() + " 主机名：" + request.getRemoteHost() + " 访问资源：" + req.getRequestURI());
		out.flush();
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
