package com.wellsfargo.interviews.dao.impl;

import com.wellsfargo.interviews.dao.SkillDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.wellsfargo.interviews.hibernate.util.*;
import org.hibernate.HibernateException;
import javax.persistence.EntityNotFoundException;

import com.wellsfargo.interviews.model.Skill;
@Repository("SkillDAO")

public class SkillDAOImpl implements SkillDAO{
	
	private SessionFactory sessionFactory;
	private Transaction tx;
	private Session session;
	
	@Override
	public void addSkill(Skill skill) {

		try {
			session = HibernateAnnotationUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.persist(skill);
			tx.commit();
			System.out.println("Skill is created with Id:: " + skill.getIdSkill());
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
	public Skill updateSkill(Skill skill) {
		Skill skllupdt = null;
		
		try {
			session = HibernateAnnotationUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			skllupdt= session.get(Skill.class,skill.getIdSkill());
			System.out.println("skllupdt before setMehtod" + skllupdt);
			
			if (skllupdt != null) {
				skllupdt.setNameSkill(skill.getNameSkill());
				skllupdt.setPanel(skill.getPanel());
				System.out.println("skllupdt before persist---> " + skllupdt);
				session.persist(skllupdt);
				tx.commit();
				System.out.println("after commit" + skllupdt);
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
		return skllupdt;
	}
	
	@Override
	public Skill getSkillById(int skillId) {
		Skill skllbyId = null;
		
		try {
			session = HibernateAnnotationUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			skllbyId= session.find(Skill.class,skillId);
			if(skllbyId == null) {
				throw new EntityNotFoundException("Can't find Skill for ID " + skillId);
				} 
			} catch (HibernateException e) {
				e.printStackTrace();
				} finally {
					if (session !=null && session.isOpen()) {
						session.close();
						}
					System.out.println("get userById is: "+ skllbyId);
					}
		return skllbyId;
	}
	/*
	@Override
	public Skill getSkill(String name) {
		Skill skllbyName = null;
		try {
			sessionFactory = HibernateAnnotationUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			skllbyName = session.find(Skill.class,name);
			if(skllbyName == null) {
				throw new EntityNotFoundException("Can't find Skill for Name " + skllbyName);
				}
			} catch (HibernateException e) {
				e.printStackTrace();
				} finally {
					if (session !=null && session.isOpen()) {
						session.close();
						}
					}
		return skllbyName;
	}
*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Skill> getSkill() {
		List<Skill> skills = null;
		try {
			session = HibernateAnnotationUtil.getSessionFactory().openSession();
			skills = session.createQuery("from skill").list();
			System.out.println(skills.toString());
			} catch (HibernateException e) {
				e.printStackTrace();
				} finally {
					if (session !=null && session.isOpen()) {
						session.close();
						}
					}
		return skills;
	}

}
