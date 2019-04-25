package com.synechron.demo.dao;

import java.util.List;

import com.synechron.demo.model.User;

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
