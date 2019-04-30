package com.wellsfargo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {
		System.out.println("%%%%%%%%%%%%%%%%%%%");
//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
//				addAnnotatedClass(Student.class).
//				buildSessionFactory();
//		Session session = factory.getCurrentSession();
//		try {
//			//Use the session object to save java object
//			Student tempStudent = new Student("Dffy", "Duck", "Duck@email.com");
//			//create a student object
//			session.beginTransaction();
//			//Start transactionç
//			
//			System.out.println(tempStudent);
//			session.save(tempStudent);
//			//save the student Object
//			session.getTransaction().commit();
//			//Commit transaction
//			
//			
//			System.out.println("Saved student generated id: " + tempStudent.getId());
//			
//			//Now get a new Session and start transaction 
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			
//			System.out.println("Getting student generated id: " + tempStudent.getId());
//			Student myStudent = (Student) session.get(Student.class, tempStudent.getId());
//			System.out.println("Get Complete " + myStudent);
//			
//			session.getTransaction().commit();
//
//			System.out.println("DONE!");
//
//			
//		}
//		finally {
//			factory.close();
//		}
//		
	}

}
