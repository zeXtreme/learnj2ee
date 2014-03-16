package me.zwy.dao;

import me.zwy.vo.Content;

public interface ContentDao {
	
	public boolean addContent(int userId,String content);
	public boolean deleteContent(Content content);
	public boolean setContent(Content content,String newContent);
	public Content findContent(int pid);

}
