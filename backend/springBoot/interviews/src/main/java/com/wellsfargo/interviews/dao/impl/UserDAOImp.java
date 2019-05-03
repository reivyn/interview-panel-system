package com.wellsfargo.interviews.dao.impl;

import com.wellsfargo.interviews.dao.UserDAO;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.wellsfargo.interviews.hibernate.util.*;
import com.wellsfargo.interviews.model.User;
import javax.persistence.EntityNotFoundException;

@Repository("UserDAO")
public class UserDAOImp implements UserDAO {
	
	private SessionFactory sessionFactory;
	private Transaction tx;
	private Session session;
	
	@Override
	public void addUser(User user) {
		try {
			session = HibernateAnnotationUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.persist(user);
			tx.commit();
			System.out.println("User is created with Id:: " + user.getIdUser());
		} catch (HibernateException e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session !=null && session.isOpen()) {
				session.close();
				}
			}
		}
		
	@Override
	public User updateUser(User user) {
		User usrupdt = null;
		
		try {
			session = HibernateAnnotationUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			usrupdt = session.get(User.class,user.getIdUser());
			System.out.println("usrupdt before setMehtod" + usrupdt);
			if (usrupdt != null) {
				usrupdt.setActiveUser(user.getActiveUser());
				usrupdt.setIdUser(user.getIdUser());
				usrupdt.setPassword(user.getPassword());
				usrupdt.setRole(user.getRole());
				usrupdt.setUsername(user.getUsername());
				System.out.println("usrupdt before persist---> " + usrupdt);
				session.persist(usrupdt);
				tx.commit();
				System.out.println("after commit" + usrupdt);
				}
			} catch (HibernateException e) {
				if (tx!=null) {
					tx.rollback();
					}
				e.printStackTrace();
				} finally {
					if (session !=null && session.isOpen()) {
						session.close();
						}
					}
		return usrupdt;
	}

	@Override
	public User getUserById(int userId) {	
		User usrbyId = null;
		try {
			session = HibernateAnnotationUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			usrbyId = session.find(User.class,userId);
			if(usrbyId == null) {
				throw new EntityNotFoundException("Can't find User for ID " + userId);
				}
			} catch (HibernateException e) {
				e.printStackTrace();
				} finally {
					if (session !=null && session.isOpen()) {
						session.close();
						}
					System.out.println("get userById is: "+ usrbyId);
					}
		return usrbyId;
	}

	/*
	@Override
	public User getUser(String username) {
		User usrbyName = null;
		try {
			sessionFactory = HibernateAnnotationUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			usrbyName = session.find(User.class,username);
			if(usrbyName == null) {
				throw new EntityNotFoundException("Can't find User for Name " + usrbyName);
				}
			} catch (HibernateException e) {
				e.printStackTrace();
				} finally {
					if (session !=null && session.isOpen()) {
						session.close();
						}
					}
		return usrbyName;
	}
*/
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		List<User> users = null;
		try {
			session = HibernateAnnotationUtil.getSessionFactory().openSession();
			users = session.createQuery("from user").list();
			System.out.println(users.toString());
			} catch (HibernateException e) {
				e.printStackTrace();
				} finally {
					if (session !=null && session.isOpen()) {
						session.close();
						}
					}
		return users;
	}

}
