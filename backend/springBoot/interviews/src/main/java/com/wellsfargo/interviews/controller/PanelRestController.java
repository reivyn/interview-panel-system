package com.wellsfargo.interviews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wellsfargo.interviews.service.panel.*;
import com.wellsfargo.interviews.model.*;
// import Panel manag.interviewser
// import slot bean
@CrossOrigin
@RestController
//@RequestMapping("/panels")
public class PanelRestController {
	
	public PanelRestController() {
	}
	
	@Autowired
	private PanelManager panelManager;
	
	
	
	@GetMapping("/panels")	
	public ResponseEntity<List<Panel>> getPanels() {
		List<Panel> panels = panelManager.getPanels();
		
		return new ResponseEntity<>(panels, HttpStatus.CREATED);
	}

	@GetMapping("/panels/{panelId}")
	public ResponseEntity getPanel(@PathVariable("panelId") int panelId) {

		Panel panel = panelManager.getPanelById(panelId);
		if (panel == null) {
			return new ResponseEntity("No Panel found for ID " + panelId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(panel, HttpStatus.OK);
	}
	
	@PostMapping(value = "/panels")
	public ResponseEntity createPanel(@RequestBody Panel panel) {

		panelManager.createPanel(panel);

		return new ResponseEntity(panel, HttpStatus.OK);
	}
	
	
	

	
	
	
/*
	@DeleteMapping("/panels/{panelId}")
	public ResponseEntity deletePanel(@PathVariable Long panelId) {

		if (null == panelDAO.delete(panelId)) {
			return new ResponseEntity("No Panel found for ID " + panelId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(panelId, HttpStatus.OK);

	}
	*/

	@PutMapping("/panels/{panelId}")
	public ResponseEntity updatePanel(@PathVariable int panelId, @RequestBody Panel panel) {

		panel = panelManager.updatePanel(panelId, panel);

		if (null == panel) {
			return new ResponseEntity("No Panel found for ID " + panelId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(panel, HttpStatus.OK);
	}

}