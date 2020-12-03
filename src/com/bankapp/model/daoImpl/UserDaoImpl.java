package com.bankapp.model.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.dao.UserDao;
import com.bankapp.model.dao.exceptions.UserNotFoundException;
import com.bankapp.model.entities.User;
@Repository
public class UserDaoImpl implements UserDao{

	private SessionFactory factory;
	
	@Autowired
	public UserDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
    
	private Session getSession()
	{
		return factory.getCurrentSession();
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return getSession().createQuery("select u from User u").list();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		getSession().update(user);
		return user;
	}

	@Override
	public User delUser(User user) {
		// TODO Auto-generated method stub
		User userToBeDeleted = getUserById(user.getuId());
		getSession().delete(userToBeDeleted);
		return userToBeDeleted;
	}

	@Override
	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		Query getuser = getSession().createQuery("from User where username=:username1 and password=:password1");
		getuser.setParameter("username1", username);
		getuser.setParameter("password1", password);
		User user = (User)  getuser.getSingleResult();
		if(user==null)
			throw new UserNotFoundException("User "+username+" not found");
		return user;
	}
	@Override
	public User getUserById(int accountId) {
		User user = getSession().get(User.class, accountId);
		return user;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		getSession().persist(user);
		return user;
	}

}
