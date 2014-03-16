package me.zwy.work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编写一个Servlet使用请求对象获取客户端信息：主机名、IP地址、端口、请求的协议、编码等，将结果显示到表格中。
 * @author Zeng
 *
 */
public class ClientInfo implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String hostName = req.getRemoteHost();
		String host = req.getRemoteAddr();
		int port = req.getRemotePort();
		String protocol = req.getProtocol();
		String encode = req.getCharacterEncoding();
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<html><head><title>ClientInfo</title></head><body><table align='center' border='1'><tr><td>" + hostName + "</td></tr><tr><td>" + host + "</td></tr><tr><td>" + port + "</td></tr><tr><td>" + protocol + "</td></tr><tr><td>" + encode + "</td></tr></table></body></html>");
		out.flush();
		out.close();
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}

}
