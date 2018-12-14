package com.oracle.service.impl;

import java.util.List;


import com.oracle.dao.ICategory;
import com.oracle.dao.impl.ICategoryImpl;
import com.oracle.entity.Product_category;
import com.oracle.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private ICategory ics = new ICategoryImpl();

	@Override
	public List<Product_category> selectcategory() {
		return ics.selectcategory();
	}


}
