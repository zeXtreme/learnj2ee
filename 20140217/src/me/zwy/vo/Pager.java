package me.zwy.vo;

import java.util.List;

public class Pager {
	
	private List<Employee> list;
	private int total;
	public List<Employee> getList() {
		return list;
	}
	public void setList(List<Employee> list) {
		this.list = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

}
