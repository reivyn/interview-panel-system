package com.wellsfargo.service.skill.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.service.skill.SkillManager;


// import skill DAO 
// import skill model
public class SkillManagerImpl implements SkillManager {

	  @Resource
	  private SkillDAO skillDAO;
	  
	 @Override
	  @Transactional
	  public void createSkill(Skill skill) {
	    skillDAO.insertSkill(skill);
	  }
	  
	

	  @Override
	  @Transactional
	  public Skill getSkillById(int skillId) {
	    return skillDAO.getSkillById(skillId);
	  }
	  
	  @Override
	  @Transactional
	  public Skill getSkill(String skillname) {
	    return skillDAO.getSkill(skillname);
	  }
	  
	  @Override
	  @Transactional
	  public Skill updateSkill(int skillId, Skill skill) {
		  return skillDAO.updateSkill(skill);
	  }
	  
	  
	  @Override
	  @Transactional
	  public Skill deleteSkill(int skillId) {
		   return skillDAO.deleteSkill(skillId);
		  
	  }
	  
	  
	  @Override
	  @Transactional
	  public List<Skill> getSkills() {
		  //  final List<Skill> list = skillDAO.find(Skill.class);
		   // return list;
	    return skillDAO.getSkills();
	  }
}




