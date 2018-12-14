package com.oracle.entity;

public class Cart {
	private long id;
	private long pid;
	private long quantity;
	private long userid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "ShopCarts [id=" + id + ", pid=" + pid + ", quantity=" + quantity + ", userid=" + userid + "]";
	}

}
