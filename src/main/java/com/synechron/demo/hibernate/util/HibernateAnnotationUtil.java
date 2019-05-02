package com.synechron.demo.hibernate.util;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.synechron.demo.model.Panel;
import com.synechron.demo.model.Role;
import com.synechron.demo.model.Skill;
import com.synechron.demo.model.User;

/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

public class HibernateAnnotationUtil {
		
	private static ServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
				Map<String, Object> settings = new HashMap<>();
				settings.put(Environment.DATASOURCE, getDataSource());
				settings.put(Environment.HBM2DDL_AUTO,"update");
				settings.put(Environment.SHOW_SQL, "true");
				registryBuilder.applySettings(settings);
	            registry = registryBuilder.build();
	            
	            MetadataSources sources = new MetadataSources(registry).addAnnotatedClass(User.class);
	            sources.addAnnotatedClass(Role.class);
	            sources.addAnnotatedClass(Panel.class);
	            sources.addAnnotatedClass(Skill.class);
				
	            Metadata metadata = sources.getMetadataBuilder().build();
	            System.out.println("Hibernate Annotation metadata created");
	            
	            sessionFactory = metadata.getSessionFactoryBuilder().build();
	            System.out.println(sessionFactory);
	        	System.out.println("Hibernate Annotation Configuration loaded");			
			} catch (Throwable ex) {
				System.out.println("catch");
				if (registry != null) {
					System.out.println("if");
		               StandardServiceRegistryBuilder.destroy(registry);
		            }
				System.err.println("Initial SessionFactory creation failed." + ex);
	            ex.printStackTrace();
	            throw new ExceptionInInitializerError(ex);
			}
		}
		return sessionFactory;
	}
	
	 public static void shutdown() {
	      if (registry != null) {
	         StandardServiceRegistryBuilder.destroy(registry);
	      }
	   }
	
	public static DataSource getDataSource() {
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	      dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/synedemo?autoReconnect=true");
	      dataSource.setUsername("root");
	      dataSource.setPassword("password");

	      // Connection pooling properties
	      //testPoll
//	      dataSource.setInitialSize(10);
//	      dataSource.setMaxIdle(15);
//	      dataSource.setMaxTotal(20);
//	      dataSource.setMinIdle(5);
//	      dataSource.setMaxWaitMillis(-1);
	      
	      dataSource.setInitialSize(0);
	      dataSource.setMaxIdle(5);
	      dataSource.setMaxTotal(5);
	      dataSource.setMinIdle(0);

	      return dataSource;
	   }

}
