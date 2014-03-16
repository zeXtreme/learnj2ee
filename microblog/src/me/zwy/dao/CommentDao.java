package me.zwy.dao;

import me.zwy.vo.Comment;

public interface CommentDao {
	
	public boolean addComment(int pid,int userId,String content);
	public boolean deleteComment(int cid);
	public boolean setContent(Comment comment,String newContent);
	public Comment findComment(int cid);

}
