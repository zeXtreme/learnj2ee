package me.zwy.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class MyDateTag implements Tag {
	
	private PageContext page = null;
	
	private String format;

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void setPageContext(PageContext pc) {
		this.page = pc;
	}

	@Override
	public void setParent(Tag t) {

	}

	@Override
	public Tag getParent() {
		return null;
	}

	@Override
	public int doStartTag() throws JspException {
		return Tag.SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = page.getOut();
		Date date = new Date();
		try {
			if(format==null || format.trim().equals("")){
				out.print("��ǰʱ�䣺" + date.toLocaleString());
			}else{
				out.print("��ǰʱ�䣺" + new SimpleDateFormat(format).format(date));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Tag.EVAL_PAGE;
	}

	@Override
	public void release() {

	}

}
