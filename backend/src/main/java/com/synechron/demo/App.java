package com.synechron.demo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.synechron.demo.hibernate.util.HibernateAnnotationUtil;
import com.synechron.demo.model.Panel;
import com.synechron.demo.model.Role;
import com.synechron.demo.model.Skill;
import com.synechron.demo.model.User;

public class App {
	public static void main( String[] args )
    {		
		//Add Role		
		Role rol1 = new Role();
		rol1.setIdRole(3);
		rol1.setNameRole("rol1_Hibernate");
		
		//Add User
		User us1 = new User();
		us1.setIdUser(5);
		us1.setActiveUser(1);
		us1.setPassword("123");
		us1.setUsername("userTestHibernate");
		
		User us2 = new User();
		us2.setIdUser(4);
		us2.setActiveUser(1);
		us2.setPassword("123");
		us2.setUsername("twoTestHibernate");
			
		Set <Role> roles = new HashSet<Role>();
		roles.add(rol1);
		
		us1.setRole(roles);
		
		//Add Skill
		Skill sk1 = new Skill();
		sk1.setIdSkill(2);
		sk1.setNameSkill("JavaSprinHibernate");
		
		//Add Panel
		Panel pan1 = new Panel();
		pan1.setIdPanel(pan1.getIdPanel());
		pan1.setUserId(us1.getIdUser());
		pan1.setIdSyne(9);
		pan1.setNamePanel("pan1_NameHibernate");
		pan1.setSurnamePanel("pan1_SurnameHibernate");
		pan1.setPhone("0000000000");
		pan1.setEmailSyne("emailSyne@synechron.com");
		pan1.setDesignation("2");
		
		Set<Skill> skills = new HashSet<Skill>();
		skills.add(sk1);
		
		pan1.setSkill(skills);
		
		SessionFactory sessionFactory = null;
		
		try {
			
			sessionFactory = HibernateAnnotationUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.save(us1);
			session.save(pan1);
			System.out.println("Before committing transaction");
			
			tx.commit();
			sessionFactory.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
		}
		
    }
}
