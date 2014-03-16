package com.web.dao;

import com.web.vo.User;

public interface UserDao {

	public boolean addUser(User user);
	public boolean changeUser(int userId,User newUser);
	public User findById(int userId);
	public User findByUserName(String userName);
	
}
