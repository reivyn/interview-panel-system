package com.wellsfargo.interviews.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

@Entity(name="panel")
@Table(name = "panel",uniqueConstraints= @UniqueConstraint(columnNames="id"))
public class Panel implements Serializable{
	
	private static final long serialVersionUID = 2046123816844029364L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",unique=true, nullable=false)
	private Integer idPanel;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "id_syne", unique = true)
	private Integer idSyne;
	
	@Column(name = "name")
	private String namePanel;
	
	@Column(name = "surname")
	private String surnamePanel;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "extension")
	private String extension;
	
	@Column(name = "email_syne")
	private String emailSyne;
	
	@Column(name = "email_wf")
	private String emailWf;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "level")
	private String level;
	
	@Column(name = "slots")
	private String slots;
	@JsonIgnore
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="panel_skill", joinColumns={@JoinColumn(referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
	private Set<Skill> skill;
	

	public Panel() {
	}

	public Panel(Integer idPanel, Integer userId, Integer idSyne, String namePanel, String surnamePanel, String phone,
			String extension, String emailSyne, String emailWf, String designation, String level, String slots) {
		this.idPanel = idPanel;
		this.userId = userId;
		this.idSyne = idSyne;
		this.namePanel = namePanel;
		this.surnamePanel = surnamePanel;
		this.phone = phone;
		this.extension = extension;
		this.emailSyne = emailSyne;
		this.emailWf = emailWf;
		this.designation = designation;
		this.level = level;
		this.slots = slots;
	}

	public Integer getIdPanel() {
		return idPanel;
	}

	public void setIdPanel(Integer idPanel) {
		this.idPanel = idPanel;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getIdSyne() {
		return idSyne;
	}

	public void setIdSyne(Integer idSyne) {
		this.idSyne = idSyne;
	}

	public String getNamePanel() {
		return namePanel;
	}

	public void setNamePanel(String namePanel) {
		this.namePanel = namePanel;
	}

	public String getSurnamePanel() {
		return surnamePanel;
	}

	public void setSurnamePanel(String surnamePanel) {
		this.surnamePanel = surnamePanel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmailSyne() {
		return emailSyne;
	}

	public void setEmailSyne(String emailSyne) {
		this.emailSyne = emailSyne;
	}

	public String getEmailWf() {
		return emailWf;
	}

	public void setEmailWf(String emailWf) {
		this.emailWf = emailWf;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSlots() {
		return slots;
	}

	public void setSlots(String slots) {
		this.slots = slots;
	}

	public Set<Skill> getSkill() {
		return skill;
	}

	public void setSkill(Set<Skill> skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Panel [idPanel=" + idPanel + ", userId=" + userId + ", idSyne=" + idSyne + ", namePanel=" + namePanel
				+ ", surnamePanel=" + surnamePanel + ", phone=" + phone + ", extension=" + extension + ", emailSyne="
				+ emailSyne + ", emailWf=" + emailWf + ", designation=" + designation + ", level=" + level + ", slots="
				+ slots + "]";
	}
	
}