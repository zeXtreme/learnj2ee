package me.zwy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@SuppressWarnings("serial")
public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		try {
			su.setDeniedFilesList("exe");
			su.setAllowedFilesList("jpg");
			su.setMaxFileSize(1000*1024*1024*1024);
			su.upload();
			int n = su.save("upload");
			out.print("成功的个数为：" + n);
			Files fs = su.getFiles();
			for(int i=0;i<fs.getCount();i++){
				File f = fs.getFile(i);
				out.print("<br>上传的文件名：" + f.getFileName() + "<<<DESC:" + su.getRequest().getParameter("desc"));
				out.print("<br>文件路径：upload/" + f.getFilePathName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

}
