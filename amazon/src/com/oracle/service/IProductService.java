package com.oracle.service;

import java.util.List;

import com.oracle.entity.Product;

public interface IProductService {

	public List<Product> getProducts();

	/**
	 * 按照外键父类id查询商品
	 */
	public List<Product> getPProducts(long pid);

	/**
	 * 按照外键子类id查询商品
	 */
	public List<Product> getCProduct(long pcid);

	/**
	 * 按照商品id查询商品
	 */
	public Product getProduct(long pcid);
	

	/**
	 * 按照搜索得到查询结果
	 */
	public List<Product> getseekProducts(String pname);

	/**
	 * 得到热卖商品
	 */
	public List<Product> gethotproduct();
	
	/**
	 * 修改库存
	 */
	public boolean updetePronums(long pid,long num);

	/**
	 * 释放资源，关闭连接
	 */
	public void release();

}
