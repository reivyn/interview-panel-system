package com.synechron.demo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.synechron.demo.dao.SkillDAO;
import com.synechron.demo.model.Skill;

public class SkillDAOImpl implements SkillDAO{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}

	@Override
	public void addSkill(Skill skill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveSkill(Skill skill) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(skill);
		tx.commit();
		session.close();
		
	}

	@Override
	public Skill getSkillById(int skillId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill getSkill(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Skill> getSkill() {
		Session session = this.sessionFactory.openSession();
		List<Skill> skills = session.createQuery("from skill").list();
		session.close();
		return skills;
	}

}
