package com.oracle.entity;

import java.sql.Date;

public class Comment {
	private long hc_id;
	private String hc_pepiy;
	private String hc_content;
	private Date hc_create_time;
	private Date hc_reply_time;
	private String Hc_nick_name;
	private String Hc_state;

	public long getHc_id() {
		return hc_id;
	}

	public void setHc_id(long hc_id) {
		this.hc_id = hc_id;
	}

	public String getHc_pepiy() {
		return hc_pepiy;
	}

	public void setHc_pepiy(String hc_pepiy) {
		this.hc_pepiy = hc_pepiy;
	}

	public String getHc_content() {
		return hc_content;
	}

	public void setHc_content(String hc_content) {
		this.hc_content = hc_content;
	}

	public Date getHc_create_time() {
		return hc_create_time;
	}

	public void setHc_create_time(Date hc_create_time) {
		this.hc_create_time = hc_create_time;
	}

	public Date getHc_reply_time() {
		return hc_reply_time;
	}

	public void setHc_reply_time(Date hc_reply_time) {
		this.hc_reply_time = hc_reply_time;
	}

	public String getHc_nick_name() {
		return Hc_nick_name;
	}

	public void setHc_nick_name(String hc_nick_name) {
		Hc_nick_name = hc_nick_name;
	}

	public String getHc_state() {
		return Hc_state;
	}

	public void setHc_state(String hc_state) {
		Hc_state = hc_state;
	}

}
