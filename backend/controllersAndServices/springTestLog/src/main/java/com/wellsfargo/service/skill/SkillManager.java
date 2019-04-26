package com.wellsfargo.service.skill;

//import skillModel

public interface SkillManager {

	  void createSkill(Skill skill);
		
	  Skill getSkillById(int skillId);
		
	  Skill getSkill(String skillname);
	  
	  Skill deleteSkill(int skillId);
	  
	  Skill updateSkill(int skillId, Skill skill);
		
	  List<Skill> getSkills();
	
}
