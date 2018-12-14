package com.oracle.entity;

import java.sql.Date;

public class News {
	private long hn_id;
	private String hn_title;
	private String content;
	private Date hn_create_time;

	public long getHn_id() {
		return hn_id;
	}

	public void setHn_id(long hn_id) {
		this.hn_id = hn_id;
	}

	public String getHn_title() {
		return hn_title;
	}

	public void setHn_title(String hn_title) {
		this.hn_title = hn_title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getHn_create_time() {
		return hn_create_time;
	}

	public void setHn_create_time(Date hn_create_time) {
		this.hn_create_time = hn_create_time;
	}

}
