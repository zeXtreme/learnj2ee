package me.zwy.dao;

import me.zwy.vo.Post;

public interface PostDao {

	public boolean createPost(String title,String context,String author_id);
	public boolean deletePost(String id);
	public boolean editPost(String id,String title,String context);
	public Post findById(String id);
	
}
