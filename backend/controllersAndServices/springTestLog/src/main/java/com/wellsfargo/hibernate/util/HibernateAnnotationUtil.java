package com.wellsfargo.hibernate.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.wellsfargo.model.Panel;
import com.wellsfargo.model.Role;
import com.wellsfargo.model.Skill;
import com.wellsfargo.model.User;

/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

public class HibernateAnnotationUtil {
	

	private static SessionFactory sessionFactory;
//	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			
//			SessionFactory s = new Configuration().configure("hibernate.cfg.xml").
//					addAnnotatedClass(User.class).
//					addAnnotatedClass(Role.class).
//					addAnnotatedClass(Panel.class).
//					addAnnotatedClass(Skill.class).
//					
//					buildSessionFactory();
			
			System.out.println("UNOENTRA");
        	Configuration configuration = new Configuration();
        	System.out.println("DOSENTRA");
        	configuration.addAnnotatedClass(User.class);
        	configuration.addAnnotatedClass(Role.class);
        	configuration.addAnnotatedClass(Panel.class);
        	configuration.addAnnotatedClass(Skill.class);
        	
        	configuration.configure("hibernate.cfg.xml");
        	System.out.println("Hibernate Annotation Configuration loaded");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate Annotation serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
			
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

}