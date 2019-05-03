package com.wellsfargo.interviews.dao.impl;
import org.hibernate.HibernateException;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import com.wellsfargo.interviews.hibernate.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.wellsfargo.interviews.dao.PanelDAO;
import com.wellsfargo.interviews.model.Panel;
@Repository("PanelDAO")
public class PanelDAOImp implements PanelDAO {

		
		private SessionFactory sessionFactory;
		private Transaction tx;
		private Session session;

		@Override
		public void addPanel(Panel panel) {
			try {
				session = HibernateAnnotationUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
				session.persist(panel);
				tx.commit();
				System.out.println("Panel is created with Id:: " + panel.getIdPanel());
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
			}

		@Override
		public Panel updatePanel(Panel panel) {
			Panel pupdt = null;
			
			try {
				session = HibernateAnnotationUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();
				pupdt = session.get(Panel.class, panel.getIdPanel());
				System.out.println("pupdt before setMehtod" + pupdt);
				if (pupdt != null) {
					pupdt.setIdSyne(panel.getIdSyne());
					pupdt.setNamePanel(panel.getNamePanel());
					pupdt.setSurnamePanel(panel.getSurnamePanel());
					pupdt.setPhone(panel.getPhone());
					pupdt.setExtension(panel.getExtension());
					pupdt.setEmailSyne(panel.getEmailSyne());
					pupdt.setEmailWf(panel.getEmailWf());
					pupdt.setDesignation(panel.getDesignation());
					pupdt.setLevel(panel.getLevel());
					pupdt.setSlots(panel.getSlots());
					System.out.println("usrupdt before persist---> " + pupdt);
					session.persist(pupdt);
					tx.commit();
					System.out.println("after commit" + pupdt);
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
			return pupdt;
		}
		
		@Override
		public Panel findPanelById(int panelId) {
			Panel pbyId = null;
			
			try {
				session = HibernateAnnotationUtil.getSessionFactory().openSession();				tx = session.beginTransaction();
				pbyId = session.find(Panel.class,panelId);
				if(pbyId == null) {
					throw new EntityNotFoundException("Can't find User for ID " + pbyId);
					}
				} catch (HibernateException e) {
					e.printStackTrace();
					} finally {
						if (session !=null && session.isOpen()) {
							session.close();
							}
						System.out.println("get userById is: "+ pbyId);
						}
			return pbyId;
		}
		
		

		@SuppressWarnings("unchecked")
		@Override
		public List<Panel> getPanels() {
			List<Panel> panels = null;
			try {
				session = HibernateAnnotationUtil.getSessionFactory().openSession();
				panels = session.createQuery("from panel").list();
				System.out.println(panels.toString());
				} catch (HibernateException e) {
					e.printStackTrace();
					} finally {
						if (session !=null && session.isOpen()) {
							session.close();
							}
						}
			return panels;
		}

	}
