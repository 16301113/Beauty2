package com.oracle.entity;

public class Product {
	private long hp_id;
	private String hp_name;
	private String hp_description;
	private double hp_price;
	private long hp_stock;
	private long hpc_id;
	private long hpc_child_id;
	private String hp_file_name;
	private Cart carts = new Cart();// 数量

	public Cart getCarts() {
		return carts;
	}

	public void setCarts(Cart carts) {
		this.carts = carts;
	}

	public long getHp_id() {
		return hp_id;
	}

	public void setHp_id(long hp_id) {
		this.hp_id = hp_id;
	}

	public String getHp_name() {
		return hp_name;
	}

	public void setHp_name(String hp_name) {
		this.hp_name = hp_name;
	}

	public String getHp_description() {
		return hp_description;
	}

	public void setHp_description(String hp_description) {
		this.hp_description = hp_description;
	}

	public double getHp_price() {
		return hp_price;
	}

	public void setHp_price(double hp_price) {
		this.hp_price = hp_price;
	}

	public long getHp_stock() {
		return hp_stock;
	}

	public void setHp_stock(long hp_stock) {
		this.hp_stock = hp_stock;
	}

	public long getHpc_id() {
		return hpc_id;
	}

	public void setHpc_id(long hpc_id) {
		this.hpc_id = hpc_id;
	}

	public long getHpc_child_id() {
		return hpc_child_id;
	}

	public void setHpc_child_id(long hpc_child_id) {
		this.hpc_child_id = hpc_child_id;
	}

	public String getHp_file_name() {
		return hp_file_name;
	}

	public void setHp_file_name(String hp_file_name) {
		this.hp_file_name = hp_file_name;
	}

}
