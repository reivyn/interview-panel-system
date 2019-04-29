package com.wellsfargo.dao;

import java.util.List;

import com.wellsfargo.model.User;
/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */

public interface UserDAO {
	
	void add(User user);
	void saveUser(User user);
	User getUserById(int userId);
	User getUser(String username);
	List<User> getUsers();

}