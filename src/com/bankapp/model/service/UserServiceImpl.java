package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.UserDao;
import com.bankapp.model.entities.User;
@Service
@Transactional
public class UserServiceImpl implements UserService{
  private UserDao userDao;
  
  @Autowired
	public UserServiceImpl(UserDao userDao) {

	this.userDao = userDao;
}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public User delUser(User user) {
		// TODO Auto-generated method stub
		return userDao.delUser(user);
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.getUser(username, password);
	}
	@Override
	public User getUserById(int accountId) {
		
		return userDao.getUserById(accountId);
	}
	
}
