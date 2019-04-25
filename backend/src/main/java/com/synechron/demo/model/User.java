package com.synechron.demo.model;

import java.util.HashSet;
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

import org.hibernate.annotations.ColumnDefault;

/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

@Entity(name="UserEntity")
@Table(name="user",uniqueConstraints= @UniqueConstraint(columnNames="id"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",unique=true, nullable=false)
	private Integer id;
	
	@Column(name = "username", unique = false, nullable = false, length = 20)
	private String username;
	
	@Column(name = "password", unique = false, nullable = false, length = 20)
	private String password;
	
	@Column(name = "active")
	@ColumnDefault("1")
	private int active;
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="user_role", joinColumns={@JoinColumn(referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
	private Set<Role> roles= new HashSet<Role>();
	
//	@ManyToMany(cascade= {CascadeType.ALL})
//	@JoinTable(name="user_role", joinColumns={@JoinColumn(name="id")}, inverseJoinColumns={@JoinColumn(name="id")})
//	private Set<Role> roles= new HashSet<>();

	public User() {

	}

	public User(int id, String username, String password, int active) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
