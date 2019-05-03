package com.wellsfargo.interviews.service.panel;


import java.util.List;

import com.wellsfargo.interviews.model.*;

public interface PanelManager {

// //panelDAO.getSlot(panelId, slotId);
	
	
  void createPanel(Panel panel);
	
  Panel getPanelById(int panelId);
	
  //Panel getPanel(String panelname);
  
  Panel updatePanel(int panelId, Panel panel);
	
  List<Panel> getPanels();

}


