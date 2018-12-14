package com.oracle.dao;

import java.util.List;

import com.oracle.entity.Product;

public interface IProduct {
	/**
	 * 查询商品
	 */
	public List<Product> selectProduct();

	/**
	 * 按照外键父类id查询商品
	 */
	public List<Product> selectProducts(long pid);

	/**
	 * 按照外键子类id查询商品
	 */
	public List<Product> selectchildProduct(long pcid);

	/**
	 * 按照商品id查询商品
	 */
	public Product selectProduct(long pcid);

	/**
	 * 搜索查询商品
	 */
	public List<Product> seekProducts(String pname);
	
	/**
	 * 找出热卖商品
	 */
	public List<Product> selhotproduct();
	
	/**
	 * 修改库存
	 */
	public boolean updetePronum(long pid,long num);
}
