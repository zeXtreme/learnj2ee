package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import me.zwy.util.DBConnection;

@SuppressWarnings("serial")
public class AddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = DBConnection.getConnection();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String fileName = null;
		SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		su.setAllowedFilesList("jpg,png,gif,jpeg");
		su.setMaxFileSize(10000);
		try {
			su.upload();
			int n = su.save("upload");
			if(n==0){
				out.print("<script>alert('ÃÌº” ß∞‹')</script>");
				response.setHeader("refresh", "0;url=admin/addproduct.jsp");
			}
			Files fs = su.getFiles();
			File f = fs.getFile(0);
			fileName = getFileName(f);
			f.saveAs("upload/" + fileName);
		} catch (SmartUploadException e) {
			e.printStackTrace();
			out.print("<script>alert('ÃÌº” ß∞‹');</script>");
			response.setHeader("refresh", "0;url=admin/addproduct.jsp");
		}
		Request req = su.getRequest();
		String pid = req.getParameter("pid");
		String pname = req.getParameter("pname");
		String pbrand = req.getParameter("pbrand");
		String ptype = req.getParameter("ptype");
		String pprice = req.getParameter("pprice");
		String pdesc = req.getParameter("pdesc");
		String pimage = "upload/" + fileName;
		String sql = "insert into product values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pbrand);
			ps.setString(4, ptype);
			ps.setString(5, pprice);
			ps.setString(6, pdesc);
			ps.setString(7, pimage);
			int n = ps.executeUpdate();
			if(n<1){
				out.print("<script>alert('ÃÌº” ß∞‹');</script>");
				response.setHeader("refresh", "0;url=admin/addproduct.jsp");
			}else{
				out.print("<script>alert('ÃÌº”≥…π¶');</script>");
				response.setHeader("refresh", "0;url=admin/addproduct.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			out.print("<script>alert('ÃÌº” ß∞‹');</script>");
			response.setHeader("refresh", "0;url=admin/addproduct.jsp");
		}
		out.flush();
		out.close();
	}
	
	public String getFileName(File f){
		String ex = f.getFileExt();
		String fileName = null;
		Date date = new Date();
		String sdate = (date.getYear()+1900) + "" + (date.getMonth()+1) + date.getDate() + date.getHours() + date.getMinutes() + date.getSeconds();
		fileName = sdate + "." + ex;
		return fileName;
	}

}
