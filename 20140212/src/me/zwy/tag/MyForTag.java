package me.zwy.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

public class MyForTag implements BodyTag {

	private BodyContent content;
	private PageContext page;
	
	private int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int doAfterBody() throws JspException {
		if(--count>0){
			return EVAL_BODY_AGAIN;
		}
		return SKIP_BODY;
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
		if(count<=0){
			return SKIP_BODY;
		}
		return EVAL_BODY_BUFFERED;
	}

	@Override
	public int doEndTag() throws JspException {
		if(content!=null){
			JspWriter out = page.getOut();
			try {
				out.print(content.getString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return EVAL_PAGE;
	}

	@Override
	public void release() {

	}

	@Override
	public void setBodyContent(BodyContent b) {
		this.content = b;
	}

	@Override
	public void doInitBody() throws JspException {

	}

}
