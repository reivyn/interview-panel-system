package com.wellsfargo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import SKILL Model

@RestController
public class SkillRestController {


	
	@Autowired
	private SkillManager skillManager;

	
	@GetMapping("/skills")
	public ResponseEntity<List<Skill>> getSkills() {
		List<Skills> skills = skillManager.getSkills();
		return new ResponseEntity<>(skills, HttpStatus.CREATED);
	}
	
	@GetMapping("/skills/{skillId}")
	public ResponseEntity getSkill(@PathVariable("skillId") int skillId) {

		Skill skill = skillManager.get(skillId);
		if (skill == null) {
			return new ResponseEntity("No Skill found for ID " + skillId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(skill, HttpStatus.OK);
	}
	
	@PostMapping(value = "/skills")
	public ResponseEntity createSkill(@RequestBody Skill skill) {

		skillManager.create(skill);

		return new ResponseEntity(skill, HttpStatus.OK);
	}
/*
	@DeleteMapping("/skills/{skillId}")
	public ResponseEntity deleteSkill(@PathVariable Long skillId) {

		if (null == skillManager.delete(skillId)) {
			return new ResponseEntity("No Skill found for ID " + skillId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(skillId, HttpStatus.OK);

	}
	*/

	@PutMapping("/skills/{skillId}")
	public ResponseEntity updateSkill(@PathVariable int skillId, @RequestBody Skill skill) {
		
		skill = skillManager.updateSkill(skillId, skill);

		if (null == skill) {
			return new ResponseEntity("No Skill found for ID " + skillId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(skill, HttpStatus.OK);
	}

}
