package me.zwy.tag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloWorld implements Tag {

	PageContext page = null;
	
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int doEndTag() throws JspException {
		Date d = new Date();
		String date = (d.getYear() + 1900) + "年" + (d.getMonth() + 1) + "月" + d.getDate() + "日" + " " + d.getHours() + "时" + d.getMinutes() + "分";
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
	public void setPageContext(PageContext page) {
		this.page = page;
	}

	@Override
	public void setParent(Tag tag) {

	}

}
