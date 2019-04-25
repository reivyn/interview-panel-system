package com.synechron.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.synechron.demo.model.User;

/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

@Entity(name="roleEntity")
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(columnNames ="id")})
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "name", nullable = false, length = 20)
	private String name;

	@ManyToMany(cascade = {CascadeType.ALL}, mappedBy="roles")
	private Set<User> users= new HashSet<User>();
	
//	@ManyToMany(mappedBy="roles")
//	private Set<User> users= new HashSet<>();

	public Role() {
	}

	public Role(int id, String name, int active) {
		this.id = id;
		this.name = name;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
}
