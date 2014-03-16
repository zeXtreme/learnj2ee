package me.zwy.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.zwy.util.DBConnection;

public class Employee {

	private int empno;
	private String ename;
	private String job;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public List<Employee> getEmployee(int pageNum){
		List<Employee> list = new ArrayList<Employee>();
		try {
			int pageSize = 10;
			String sql = "select * from (select empno,ename,job,row_number() over(order by sal) rown from emp) a where rown>=? and rown<=?";
			Connection conn = DBConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, (pageNum-1)*pageSize+1);
			pst.setInt(2, pageNum*pageSize);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getTotal(){
		int total = 0;
		String sql = "select count(*) from emp";
		Connection conn = DBConnection.getConnection();
		try {
			int count = 0;
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if(rs.next()){
				count = rs.getInt(1);
			}
			total = count%10==0?count/10:count/10+1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	
}
