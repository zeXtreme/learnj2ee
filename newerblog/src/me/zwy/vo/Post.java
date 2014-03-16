package me.zwy.vo;

import java.util.Date;

public class Post {
	
	private String id;
	private String title;
	private String context;
	private String author_id;
	private Date postDate;
	public Post() {
		super();
	}
	public Post(String id, String title, String context, String author_id,
			Date postDate) {
		super();
		this.id = id;
		this.title = title;
		this.context = context;
		this.author_id = author_id;
		this.postDate = postDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

}
