/**
 * 
 */
package com.synechron.demo.dao;

import java.util.List;

import com.synechron.demo.model.Panel;

/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

public interface PanelDAO {
	
	void addPanel(Panel panel);
	Panel updatePanel(Panel panel);
	Panel findPanelById(int panelId);
	List<Panel> getPanels();

}
