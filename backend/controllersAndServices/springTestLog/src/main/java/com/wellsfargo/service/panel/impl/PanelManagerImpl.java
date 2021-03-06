package com.wellsfargo.service.panel.impl;
import com.wellsfargo.model.*;
import com.wellsfargo.service.panel.PanelManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import panelDAO
//import panelModel
import com.wellsfargo.dao.*;
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
	    return panelDAO.getPanelById(panelId);
	  }
	  
	  @Override
	  @Transactional
	  public Panel getPanel(String panelname) {
	    return panelDAO.getPanel(panelname);
	  }
	  
	  @Override
	  @Transactional
	  public Panel updatePanel(int panelId, Panel panel) {
		  	return null;
		 // return panelDAO.updatePanel(panel);
	  }
	  
	  @Override
	  @Transactional
	  public List<Panel> getPanels() {
	    return panelDAO.getPanel();
	  }
	
	
}
