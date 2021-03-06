package com.wellsfargo.service.skill.impl;
import com.wellsfargo.dao.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.service.skill.SkillManager;
import com.wellsfargo.model.*;
import com.wellsfargo.model.*;
// import skill DAO 
// import skill model
public class SkillManagerImpl implements SkillManager {

		@Autowired
	  private SkillDAO skillDAO;
	  
	 @Override
	  @Transactional
	  public void createSkill(Skill skill) {
	    skillDAO.addSkill(skill);;
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
		  return null;
					 //return userDAO.updateSkill(skillId ,skill);

	  }
	  
	  /*
	  @Override
	  @Transactional
	  public Skill deleteSkill(int skillId) {
		   return skillDAO.deleteSkill(skillId);
		  
	  }
	  */
	  
	  @Override
	  @Transactional
	  public List<Skill> getSkills() {
		  //  final List<Skill> list = skillDAO.find(Skill.class);
		   // return list;
	    return skillDAO.getSkill();
	  }



	@Override
	public Skill deleteSkill(int skillId) {
		// TODO Auto-generated method stub
		return null;
	}
}




