package com.synechron.demo.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.synechron.demo.dao.UserDAO;
import com.synechron.demo.model.User;

public class UserDAOImp implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
