package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.zwy.util.DBConnection;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@SuppressWarnings("serial")
public class AlterProServlet extends HttpServlet {

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
		SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		Request req = su.getRequest();
		String id = req.getParameter("id");
		String pid = req.getParameter("pid");
		String pname = req.getParameter("pname");
		String pbrand = req.getParameter("pbrand");
		String ptype = req.getParameter("ptype");
		String pprice = req.getParameter("pprice");
		String pdesc = req.getParameter("pdesc");
		String pimage = req.getParameter("pimage");
		if(pimage==null){
			try {
				ResultSet rs = conn.createStatement().executeQuery("select * from product where pid=" + pid);
				if(rs.next()){
					pimage = rs.getString("pimage");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			su.setAllowedFilesList("jpg,png,gif,jpeg");
			su.setMaxFileSize(10000);
			try {
				String fileName = null;
				su.upload();
				int n = su.save("upload");
				if(n==0){
					out.print("<script>alert('修改失败')</script>");
					response.setHeader("refresh", "0;url=admin/managepro.jsp");
				}
				Files fs = su.getFiles();
				File f = fs.getFile(0);
				fileName = getFileName(f);
				f.saveAs("upload/" + fileName);
				pimage = "upload/" + fileName;
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
		}
		String sql  = "update product set pid=?,pname=?,pbrand=?,ptype=?,pprice=?,pdesc=?,pimage=? where pid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pbrand);
			ps.setString(4, ptype);
			ps.setString(5, pprice);
			ps.setString(6, pdesc);
			ps.setString(7, pimage);
			ps.setString(8, id);
			int n = ps.executeUpdate();
			if(n>0){
				out.print("<script>alert('修改成功')</script>");
				response.setHeader("refresh", "0;url=admin/managepro.jsp");
			}else{
				out.print("<script>alert('修改成功')</script>");
				response.setHeader("refresh", "0;url=admin/managepro.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(pprice + pimage);
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
