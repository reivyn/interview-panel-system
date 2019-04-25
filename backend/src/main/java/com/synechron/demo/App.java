package com.synechron.demo;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.synechron.demo.hibernate.util.HibernateAnnotationUtil;
import com.synechron.demo.model.Role;
import com.synechron.demo.model.User;

public class App {
	public static void main( String[] args )
    {
		User us2 = new User(7, "userPanel5", "123457", 1);
    	User us3 = new User(7, "userPanelhgjgh6", "123459", 1 );
    	System.out.println(us3.getUsername());
    	System.out.println(us3.getRoles());
		
		
		
		User us1 = new User(6, "userPanel4", "123456", 1);
		User us23 = new User(7, "userPanel5", "123457", 1);
		
		Role r1 = new Role(3,"RolePanel", 1);
		Role r2 = new Role(3,"RolePanel", 1);
		Role r3 = new Role(3,"Recruiter", 1);
		System.out.println(us1.getRoles());
		us1.getRoles().add(r1);
		us1.getRoles().add(r2);
		us2.getRoles().add(r3);
		

		r1.getUsers().add(us1);
		r2.getUsers().add(us1);
		r3.getUsers().add(us2);
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		//Save the Model object
		session.save(us1);
		session.save(us2);
		//Commit transaction
		tx.commit();
    	
    }
}
