package com.wellsfargo.dao;


import java.util.List;

import com.wellsfargo.model.Panel;

/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

public interface PanelDAO {
	
	void addPanel(Panel panel);
	void savePanel(Panel panel);
	Panel getPanelById(int panelId);
	Panel getPanel(String name);
	List<Panel> getPanel();

}