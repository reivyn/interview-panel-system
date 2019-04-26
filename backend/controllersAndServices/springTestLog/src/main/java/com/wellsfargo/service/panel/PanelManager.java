package com.wellsfargo.service.panel;


// import panelModel
public interface PanelManager {

// //panelDAO.getSlot(panelId, slotId);
	
	
  void createPanel(Panel panel);
	
  Panel getPanelById(int panelId);
	
  Panel getPanel(String panelname);
  
  Panel updatePanel(int panelId, Panel panel);
	
  List<Panel> getPanels();

}


