package com.synechron.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

@Entity
@Table(name = "skill")
public class Skill {
	
	@Id
	@Column(name = "id", nullable=false)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(cascade = {CascadeType.ALL},mappedBy="skills")
	private Set <Panel> panels= new HashSet<Panel>();
	
//	@ManyToMany(mappedBy="skills")
//	private Set <Panel> panels= new HashSet<Panel>();

	public Skill() {
	}
	
	public Skill(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Panel> getPanels() {
		return panels;
	}

	public void setPanels(Set<Panel> panels) {
		this.panels = panels;
	}	
	
}
