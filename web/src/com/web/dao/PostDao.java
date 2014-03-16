package com.web.dao;

import com.web.vo.Post;

public interface PostDao {

	public boolean addPost(Post post);
	public boolean deletePost(int pid);
	public boolean changePost(int pid,Post newPost);
	public Post findById(int pid);
	
}
