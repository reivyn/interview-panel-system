package com.wellsfargo.interviews.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

@Entity(name="skill")
@Table(name = "skill", uniqueConstraints = {@UniqueConstraint(columnNames ="id")})
public class Skill implements Serializable{
	
	private static final long serialVersionUID = 39733727501269211L;

	@Id
	@Column(name = "id",unique=true ,  nullable=false)
	private Integer idSkill;
	
	@Column(name = "name")
	private String nameSkill;
	@JsonIgnore
	@ManyToMany(mappedBy="skill")
	private Set <Panel> panel;

	public Skill() {
	}

	public Skill(Integer idSkill, String nameSkill) {
		this.idSkill = idSkill;
		this.nameSkill = nameSkill;
	}

	public Integer getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(Integer idSkill) {
		this.idSkill = idSkill;
	}

	public String getNameSkill() {
		return nameSkill;
	}

	public void setNameSkill(String nameSkill) {
		this.nameSkill = nameSkill;
	}

	public Set<Panel> getPanel() {
		return panel;
	}

	public void setPanel(Set<Panel> panel) {
		this.panel = panel;
	}

	@Override
	public String toString() {
		return "Skill [idSkill=" + idSkill + ", nameSkill=" + nameSkill + "]";
	}
	
}