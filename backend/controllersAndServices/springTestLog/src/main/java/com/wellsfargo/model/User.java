package com.wellsfargo.model;


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

import org.hibernate.annotations.ColumnDefault;

/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

@Entity(name="user")
@Table(name="user",uniqueConstraints= @UniqueConstraint(columnNames="id"))
public class User implements Serializable {
	
	private static final long serialVersionUID = 4008155765597596766L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",unique=true, nullable=false)
	private Integer idUser;
	
	@Column(name = "active")
	@ColumnDefault("1")
	private Integer activeUser;
	
	@Column(name = "username", unique = false, nullable = false, length = 20)
	private String username;
	
	@Column(name = "password", unique = false, nullable = false, length = 20)
	private String password;
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="user_role", joinColumns={@JoinColumn(referencedColumnName="id")}, 
	inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
	private Set<Role> role;

	public User() {

	}

	public User(Integer idUser, Integer activeUser, String username, String password) {
		this.idUser = idUser;
		this.activeUser = activeUser;
		this.username = username;
		this.password = password;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(Integer activeUser) {
		this.activeUser = activeUser;
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

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", activeUser=" + activeUser + ", username=" + username + ", password="
				+ password + "]";
	}
	
}