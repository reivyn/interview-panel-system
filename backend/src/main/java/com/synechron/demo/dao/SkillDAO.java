package com.synechron.demo.dao;

import java.util.List;

import com.synechron.demo.model.Skill;

/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

public interface SkillDAO {
	
	void insertSkill(Skill skill);
	Skill getSkillById(int skillId);
	Skill getSkill(String name);
	List<Skill> getSkill();

}
