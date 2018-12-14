package com.oracle.service;

import java.util.List;



import com.oracle.entity.Product_category;

public interface CategoryService {


	/**
	 * 查询商品分类
	 * 
	 * @return
	 */
	public List<Product_category> selectcategory();
}
