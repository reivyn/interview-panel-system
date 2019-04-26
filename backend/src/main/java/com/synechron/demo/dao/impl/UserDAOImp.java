package com.synechron.demo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.synechron.demo.dao.UserDAO;
import com.synechron.demo.model.User;

public class UserDAOImp implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	
	
	@Override
	public void saveUser(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		tx.commit();
		session.close();
		
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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		Session session = this.sessionFactory.openSession();
		List<User> users = session.createQuery("from user").list();
		session.close();
		return users;
	}

}
