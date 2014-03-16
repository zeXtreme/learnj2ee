package me.zwy.dao;

import me.zwy.vo.User;

public interface UserDao {

	public boolean createUser(String userName,String passWord);
	public boolean deleteUser(String id);
	public boolean editUser(String id,String userName,String passWord);
	public User findById(String id);
	public User findByUserName(String userName);
	
}
