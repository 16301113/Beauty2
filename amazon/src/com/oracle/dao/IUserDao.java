package com.oracle.dao;

import java.util.List;

import com.oracle.entity.User;

public interface IUserDao {

	/**
	 * 注册
	 */
	public boolean saveuser(User users);

	/**
	 * 查询用户是否存在
	 */
	public boolean selectuser(String username);

	/**
	 * 查询邮箱是否存在
	 */
	public boolean selectemail(String email);

	/**
	 * 用户登录
	 * 
	 */
	public List<User> selectuser();
	
	/**
	 * 根据用户名查id
	 */
	public User selectuserid(String username);

}
