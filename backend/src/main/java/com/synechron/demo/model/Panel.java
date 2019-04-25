package com.synechron.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

@Entity
@Table(name = "panel")
public class Panel {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "id_syne", unique = true)
	private int id_syne;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "extension")
	private String extension;
	
	@Column(name = "email_syne")
	private String email_syne;
	
	@Column(name = "email_wf")
	private String email_wf;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "level")
	private String level;
	
	@Column(name = "slots")
	private String slots;
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="panel_skill", joinColumns={@JoinColumn(referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
	private Set<Skill> skills = new HashSet<Skill>();
	
//	@ManyToMany(cascade= {CascadeType.ALL})
//	@JoinTable(name="panel_skill", joinColumns={@JoinColumn(name="id")}, inverseJoinColumns={@JoinColumn(name="id")})
//	private Set<Skill> skills = new HashSet<>();

	public Panel() {
	}
	
	public Panel(int id, int user_id, int id_syne, String name, String surname, String phone, String extension,
			String email_syne, String email_wf, String designation, String level, String slots) {
		this.id = id;
		this.user_id = user_id;
		this.id_syne = id_syne;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.extension = extension;
		this.email_syne = email_syne;
		this.email_wf = email_wf;
		this.designation = designation;
		this.level = level;
		this.slots = slots;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getId_syne() {
		return id_syne;
	}

	public void setId_syne(int id_syne) {
		this.id_syne = id_syne;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getEmail_syne() {
		return email_syne;
	}

	public void setEmail_syne(String email_syne) {
		this.email_syne = email_syne;
	}

	public String getEmail_wf() {
		return email_wf;
	}

	public void setEmail_wf(String email_wf) {
		this.email_wf = email_wf;
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

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

}
