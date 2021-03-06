package com.wellsfargo.dao;

import java.util.List;

import com.wellsfargo.model.Skill;
/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

public interface SkillDAO {
	
	void addSkill(Skill skill);
	void saveSkill(Skill skill);
	Skill getSkillById(int skillId);
	Skill getSkill(String name);
	List<Skill> getSkill();

}