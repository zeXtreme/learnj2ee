package me.zwy.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CheckingImageCode extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Random random = new Random();
		String str = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<4;i++){
			int index = random.nextInt(str.length());
			sb.append(str.substring(index, index+1));
		}
		resp.setContentType("image/jpeg");//��ӦΪͼƬ����
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);//����ͼ�����
		Graphics g = image.getGraphics();//��ȡͼƬ�Ļ���
		g.setColor(Color.WHITE);//���û�����ɫΪ��ɫ
		g.fillRect(0, 0, 80, 30);//���һ������
		g.setColor(Color.BLACK);
		g.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		g.drawString(sb.toString(), 15, 20);
		for(int i=0;i<3;i++){
			Color c = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));//�����ɫ
			g.setColor(c);
			int x1 = random.nextInt(81);
			int x2 = random.nextInt(81);
			int y1 = random.nextInt(31);
			int y2 = random.nextInt(31);
			g.drawLine(x1, y1, x2, y2);
		}
		ServletOutputStream out = resp.getOutputStream();
		ImageIO.write(image, "JPEG", out);
	}
	
}
