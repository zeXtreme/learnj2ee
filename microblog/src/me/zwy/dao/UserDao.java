package me.zwy.dao;

import me.zwy.vo.User;

public interface UserDao {
	
	public boolean addUser(String userName,String passWord);
	public boolean setPassWord(User user,String newPwd);
	public User findUser(String userName);
	public User findById(int userId);

}
