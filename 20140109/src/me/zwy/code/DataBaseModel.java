package me.zwy.code;

import java.util.Vector;

import me.zwy.vo.Contact;

public class DataBaseModel {

	static Vector<Contact> cs = null;
	public static Vector<Contact> getContacts(){
		cs = new Vector<Contact>();
		Contact c = new Contact("张三", "123123123", "zs@11.com", "太平街", "牛逼大了");
		cs.add(c);
		c = new Contact("李四", "123123123", "zs@11.com", "太平街", "牛逼的人生不解释");
		cs.add(c);
		c = new Contact("王五", "123123123", "zs@11.com", "太平街", "牛逼大了");
		cs.add(c);
		c = new Contact("赵六", "123123123", "zs@11.com", "太平街", "牛逼大了");
		cs.add(c);
		return cs;
	}
	
}
