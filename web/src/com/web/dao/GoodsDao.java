package com.web.dao;

import com.web.vo.Goods;

public interface GoodsDao {
	
	public boolean addGoods(Goods goods);
	public boolean deleteGoods(int gid);
	public boolean changeGoods(int gid,Goods newGoods);
	public Goods findGoods(int gid);

}
