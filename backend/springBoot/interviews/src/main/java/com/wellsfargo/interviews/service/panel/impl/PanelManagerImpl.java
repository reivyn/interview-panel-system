package com.wellsfargo.interviews.service.panel.impl;
import com.wellsfargo.interviews.model.*;
import com.wellsfargo.interviews.service.panel.PanelManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import panelDAO
//import panelModel
import com.wellsfargo.interviews.dao.*;
@Service
public class PanelManagerImpl implements PanelManager {


	
	  @Autowired
	  private PanelDAO panelDAO;
	  
	  @Override
	  @Transactional
	  public void createPanel(Panel panel) {
	    panelDAO.addPanel(panel);
	  }
	  
	

	  @Override
	  @Transactional
	  public Panel getPanelById(int panelId) {
	    return panelDAO.findPanelById(panelId);
	  }
	  
//	  @Override
//	  @Transactional
//	  public Panel getPanel(String panelname) {
//	    return panelDAO.findPanelByName(panelname);
//	  }
	  
	  @Override
	  @Transactional
	  public Panel updatePanel(int panelId, Panel panel) {
		  	return panelDAO.updatePanel(panel);
		 // return panelDAO.updatePanel(panel);
	  }
	  
	  @Override
	  @Transactional
	  public List<Panel> getPanels() {
	    return panelDAO.getPanels();
	  }
	
	
}
