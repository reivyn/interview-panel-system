package com.synechron.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

@Entity(name="role")
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(columnNames ="id")})
public class Role implements Serializable {
	
	private static final long serialVersionUID = -1455656282477067083L;

	@Id
	@Column(name = "id", nullable = false)
	private Integer idRole;
	
	@Column(name = "name", nullable = false, length = 20)
	private String nameRole;
	
	@ManyToMany(mappedBy="role")
	private Set<User> user= new HashSet<User>();

	public Role() {
	}

	public Role(Integer idRole, String nameRole) {
		this.idRole = idRole;
		this.nameRole = nameRole;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", nameRole=" + nameRole + "]";
	}
	
}
