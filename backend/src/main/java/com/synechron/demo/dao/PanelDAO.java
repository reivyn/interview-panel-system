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
	
	void insertPanel(Panel panel);
	Panel getPanelById(int panelId);
	Panel getPanel(String name);
	List<Panel> getPanel();

}
