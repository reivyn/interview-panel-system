package com.synechron.demo.dao.impl;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.synechron.demo.dao.UserDAO;
import com.synechron.demo.hibernate.util.HibernateAnnotationUtil;
import com.synechron.demo.model.User;

public class UserDAOImp implements UserDAO {
	
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
		
		
		
		
//		session = HibernateAnnotationUtil.getSessionFactory().openSession();
//		List<User> users = session.createQuery("from user").list();
//		System.out.println(users);
//		session.close();
//		return users;
//	}

}
