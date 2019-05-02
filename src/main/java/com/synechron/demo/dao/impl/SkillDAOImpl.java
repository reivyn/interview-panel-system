package com.synechron.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.synechron.demo.dao.SkillDAO;
import com.synechron.demo.hibernate.util.HibernateAnnotationUtil;
import com.synechron.demo.model.Skill;

public class SkillDAOImpl implements SkillDAO{

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
			skllupdt = session.get(Skill.class,skill.getIdSkill());
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Skill> getSkills() {
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
