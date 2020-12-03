package com.bankapp.model.dao;

import java.util.List;
import com.bankapp.model.entities.*;
public interface UserDao {

	public List<User> getAllUsers();
	public User updateUser(User user);
	public User delUser(User user);
	public User getUser(String username,String password);
	public User addUser(User user);
	public User getUserById(int accountId);
}
