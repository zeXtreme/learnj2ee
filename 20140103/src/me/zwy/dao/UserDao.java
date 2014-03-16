package me.zwy.dao;

import me.zwy.pojo.User;

public interface UserDao {
	
	public boolean addUser(String userName,String passWord);
	
	public User findByUserName(String userName);

}
