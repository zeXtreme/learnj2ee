package me.zwy.tag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class ShowTime implements Tag {

	PageContext page = null;
	
	private String format;
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public int doEndTag() throws JspException {
		Date d = new Date();
		String date = (d.getYear() + 1900) + "��" + (d.getMonth() + 1) + "��" + d.getDate() + "��" + " " + d.getHours() + "ʱ" + d.getMinutes() + "��";
		try {
			page.getOut().print(date);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Tag.EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		return Tag.SKIP_BODY;
	}

	@Override
	public Tag getParent() {
		return null;
	}

	@Override
	public void release() {

	}

	@Override
	public void setPageContext(PageContext arg0) {
		this.page = arg0;
	}

	@Override
	public void setParent(Tag arg0) {

	}

}
