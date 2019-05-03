package com.wellsfargo.interviews.service.skill;

import java.util.List;

//import skillModel
import com.wellsfargo.interviews.model.*;
public interface SkillManager {

	  void createSkill(Skill skill);
		
	  Skill getSkillById(int skillId);
		
	  //Skill getSkill(String skillname);
	  
	  Skill deleteSkill(int skillId);
	  
	  Skill updateSkill(int skillId, Skill skill);
		
	  List<Skill> getSkills();
	
}
