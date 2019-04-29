package com.wellsfargo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wellsfargo.dao.PanelDAO;
import com.wellsfargo.model.Panel;

public class PanelDAOImp implements PanelDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPanel(Panel panel) {
		savePanel(panel);
	}

	@Override
	public void savePanel(Panel panel) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(panel);
		tx.commit();
		session.close();
	}

	@Override
	public Panel getPanelById(int panelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Panel getPanel(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Panel> getPanel() {
		Session session = this.sessionFactory.openSession();
		List<Panel> panels = session.createQuery("from panel").list();
		session.close();
		return panels;
	}

}