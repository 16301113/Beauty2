package com.oracle.dao;

import java.util.List;

import com.oracle.entity.Product_category;

public interface ICategory {

	/**
	 * 查询商品分类
	 * 
	 * @return
	 */
	public List<Product_category> selectcategory();

}
