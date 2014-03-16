package me.zwy.util;

public class LoginDaoImpl {

	public boolean isLogin(String name,String pwd){
		if(name.equals("admin")&&pwd.equals("root")){
			return true;
		}
		return false;
	}
}
