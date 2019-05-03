package com.wellsfargo.interviews.dao;

import java.util.List;

import com.wellsfargo.interviews.model.Skill;
/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

public interface SkillDAO {
	
	void addSkill(Skill skill);
//	void saveSkill(Skill skill);
	Skill updateSkill(Skill skill);
	Skill getSkillById(int skillId);
	List<Skill> getSkill();

}
