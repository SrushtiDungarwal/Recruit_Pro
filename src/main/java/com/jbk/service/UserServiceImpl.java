package com.jbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.UserDao;
import com.jbk.dao.UserDaoImpl;
import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public int createUser(User user) {
		
		int status = userDao.createUser(user);
		return status;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = userDao.getUserByUsername(username);
		return user;
	}

	@Override
	public int deleteUsername(String username) {
		int status = userDao.deleteUsername(username);
		return status;
	}

	@Override
	public User loginUser(LoginRequest loginRequest) {
		User user = userDao.loginUser(loginRequest);
		return user;
	}

}
