package me.zwy.vo;

public class Employee {

	private String id;
	private String name;
	private String[] addrs;
	public Employee() {
		super();
	}
	public Employee(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String[] getAddrs() {
		return addrs;
	}
	public void setAddrs(String[] addrs) {
		this.addrs = addrs;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
