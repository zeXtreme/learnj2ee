package me.zwy.code;

import java.util.Vector;

import me.zwy.vo.Contact;

public class DataBaseModel {

	static Vector<Contact> cs = null;
	public static Vector<Contact> getContacts(){
		cs = new Vector<Contact>();
		Contact c = new Contact("����", "123123123", "zs@11.com", "̫ƽ��", "ţ�ƴ���");
		cs.add(c);
		c = new Contact("����", "123123123", "zs@11.com", "̫ƽ��", "ţ�Ƶ�����������");
		cs.add(c);
		c = new Contact("����", "123123123", "zs@11.com", "̫ƽ��", "ţ�ƴ���");
		cs.add(c);
		c = new Contact("����", "123123123", "zs@11.com", "̫ƽ��", "ţ�ƴ���");
		cs.add(c);
		return cs;
	}
	
}
