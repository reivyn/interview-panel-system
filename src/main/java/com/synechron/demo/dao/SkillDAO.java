package com.synechron.demo.dao;

import java.util.List;

import com.synechron.demo.model.Skill;

/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

public interface SkillDAO {
	
	void addSkill(Skill skill);
	Skill updateSkill(Skill skill);
	Skill getSkillById(int skillId);
	List<Skill> getSkills();

}
