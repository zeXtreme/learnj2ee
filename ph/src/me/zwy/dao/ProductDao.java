package me.zwy.dao;

import java.util.List;

import me.zwy.vo.Product;

public interface ProductDao {

	public List<Product> getAll();
	public Product getById(String pid);
	public boolean addProduct(Product pro);
	public boolean deleteProduct(String id);
	
}
