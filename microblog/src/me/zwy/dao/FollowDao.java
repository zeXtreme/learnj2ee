package me.zwy.dao;

import me.zwy.vo.User;

public interface FollowDao {
	
	public boolean addFollow(User fans,User follow);
	public boolean cancelFollow(User fans,User follow);
	public boolean removeFans(User follow,User fans);

}
