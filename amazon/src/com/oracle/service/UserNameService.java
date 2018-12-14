package com.oracle.service;

import java.util.List;

import com.oracle.entity.User;

public interface UserNameService {

	public boolean register(User users);

	/**
	 * 检查用户是否存在
	 */
	public boolean Checkexist(String username);

	/**
	 * 检查邮箱是否存在
	 */
	public boolean Checkemail(String email);

	/**
	 * 登录
	 * 
	 */
	public List<User> login();
	public User getUserid(String username);
}
