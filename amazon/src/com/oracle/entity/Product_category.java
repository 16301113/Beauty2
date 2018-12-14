package com.oracle.entity;

import java.util.ArrayList;
import java.util.List;

public class Product_category {
	private long hpc_id;
	private String hpc_name;
	private long hpc_parent_id;
	private List<Product_category> list = new ArrayList<Product_category>();

	public long getHpc_id() {
		return hpc_id;
	}

	public void setHpc_id(long hpc_id) {
		this.hpc_id = hpc_id;
	}

	public String getHpc_name() {
		return hpc_name;
	}

	public void setHpc_name(String hpc_name) {
		this.hpc_name = hpc_name;
	}

	public long getHpc_parent_id() {
		return hpc_parent_id;
	}

	public void setHpc_parent_id(long hpc_parent_id) {
		this.hpc_parent_id = hpc_parent_id;
	}

	public List<Product_category> getList() {
		return list;
	}

	public void setList(List<Product_category> list) {
		this.list = list;
	}

}
