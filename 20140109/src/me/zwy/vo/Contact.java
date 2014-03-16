package me.zwy.vo;

public class Contact {

	private String name;
	private String tel;
	private String email;
	private String addr;
	private String common;
	
	public Contact(){
		
	}
	public Contact(String name, String tel, String email, String addr,
			String common) {
		super();
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.addr = addr;
		this.common = common;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}
	@Override
	public String toString() {
		return "<td>" + name + "</td>" + "<td>" + tel + "</td>" + "<td>" + email + "</td>" + "<td>" + addr + "</td>" + "<td>" + common + "</td>";
	}
	
}
