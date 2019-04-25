package com.synechron.demo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import com.synechron.demo.hibernate.util.HibernateAnnotationUtil;
import com.synechron.demo.model.Role;
import com.synechron.demo.model.User;

public class App {
	public static void main( String[] args )
    {
		Session session = HibernateAnnotationUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		
		//Add User
		User us1 = new User();
		us1.setId(8);
		us1.setActive(1);
		us1.setPassword("123");
		us1.setUsername("userTestHibernate");
		
		User us2 = new User();
		us2.setId(88);
		us2.setActive(1);
		us2.setPassword("123");
		us2.setUsername("twoTestHibernate");
		
		Set<User> setUser = new HashSet<User>();
		setUser.add(us1);
		setUser.add(us2);
		
		//Add Role		
		Role rol1 = new Role();
//		rol1.setId(9);
		rol1.setName("RoleHibernate");
		
		Role rol2 = new Role();
//		rol2.setId(99);	
		rol2.setName("RoleTwoHibernate");
		
		Set <Role> roles = new HashSet<Role>();
		roles.add(rol1);
		roles.add(rol2);
		
		
		
		rol1.setUsers(setUser);
		rol2.setUsers(setUser);

		session.save(rol1);
		session.save(rol2);
		
		session.getTransaction().commit();
		
    }
}
