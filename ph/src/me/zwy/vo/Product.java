package me.zwy.vo;

public class Product {

	private String pid;
	private String pname;
	private String pbrand;
	private String ptype;
	private double pprice;
	private String pimage;
	public Product() {
		super();
	}
	public Product(String pid, String pname, String pbrand, String ptype,
			double pprice, String pimage) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pbrand = pbrand;
		this.ptype = ptype;
		this.pprice = pprice;
		this.pimage = pimage;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPbrand() {
		return pbrand;
	}
	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	
}
