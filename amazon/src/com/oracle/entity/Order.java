package com.oracle.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Order {
	private long ho_id;
	private long ho_user_id;
	private String ho_user_name;
	private String ho_user_address;
	private Date ho_create_time;
	private double ho_cost;// 总金额
	private long ho_status;
	private long ho_type;
	private List<Order_detail> orderdetail = new ArrayList<Order_detail>();
	private User users = new User();

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public List<Order_detail> getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(List<Order_detail> orderdetail) {
		this.orderdetail = orderdetail;
	}

	public long getHo_id() {
		return ho_id;
	}

	public void setHo_id(long ho_id) {
		this.ho_id = ho_id;
	}

	public long getHo_user_id() {
		return ho_user_id;
	}

	public void setHo_user_id(long ho_user_id) {
		this.ho_user_id = ho_user_id;
	}

	public String getHo_user_name() {
		return ho_user_name;
	}

	public void setHo_user_name(String ho_user_name) {
		this.ho_user_name = ho_user_name;
	}

	public String getHo_user_address() {
		return ho_user_address;
	}

	public void setHo_user_address(String ho_user_address) {
		this.ho_user_address = ho_user_address;
	}

	public Date getHo_create_time() {
		return ho_create_time;
	}

	public void setHo_create_time(Date ho_create_time) {
		this.ho_create_time = ho_create_time;
	}

	public double getHo_cost() {
		return ho_cost;
	}

	public void setHo_cost(double ho_cost) {
		this.ho_cost = ho_cost;
	}

	public long getHo_status() {
		return ho_status;
	}

	public void setHo_status(long ho_status) {
		this.ho_status = ho_status;
	}

	public long getHo_type() {
		return ho_type;
	}

	public void setHo_type(long ho_type) {
		this.ho_type = ho_type;
	}

}
