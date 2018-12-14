package com.oracle.service.impl;

import java.util.List;

import com.oracle.dao.IUserDao;
import com.oracle.dao.impl.IUserDaoImpl;
import com.oracle.entity.User;
import com.oracle.service.UserNameService;

public class UserNameServiceImpl implements UserNameService {

	private IUserDao iuser = new IUserDaoImpl();

	@Override
	public boolean register(User users) {
		if (iuser.saveuser(users)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean Checkexist(String username) {

		return iuser.selectuser(username);
	}

	@Override
	public boolean Checkemail(String email) {

		return iuser.selectemail(email);
	}

	@Override
	public List<User> login() {

		return iuser.selectuser();
	}

	@Override
	public User getUserid(String username) {
		
		return iuser.selectuserid(username);
	}
}
