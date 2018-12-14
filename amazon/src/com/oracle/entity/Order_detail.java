package com.oracle.entity;

public class Order_detail {

	private long hod_id;
	private long ho_id;
	private long hp_id;
	private long hod_quantity;
	private double hod_cost;
	private Order order=new Order();
	private Product product=new Product();
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public long getHod_id() {
		return hod_id;
	}
	public void setHod_id(long hod_id) {
		this.hod_id = hod_id;
	}
	public long getHo_id() {
		return ho_id;
	}
	public void setHo_id(long ho_id) {
		this.ho_id = ho_id;
	}
	public long getHp_id() {
		return hp_id;
	}
	public void setHp_id(long hp_id) {
		this.hp_id = hp_id;
	}
	public long getHod_quantity() {
		return hod_quantity;
	}
	public void setHod_quantity(long hod_quantity) {
		this.hod_quantity = hod_quantity;
	}
	public double getHod_cost() {
		return hod_cost;
	}
	public void setHod_cost(double hod_cost) {
		this.hod_cost = hod_cost;
	}
	

}
