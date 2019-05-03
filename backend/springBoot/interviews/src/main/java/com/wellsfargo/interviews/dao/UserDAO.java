package com.wellsfargo.interviews.dao;

import java.util.List;

import com.wellsfargo.interviews.model.User;
/**
 * @author Rodolfo.Quiroz 
 * rodolfo.quiroz@synechron.com
 * version 1.0
 */


public interface UserDAO {
	
	void addUser(User user);
//	void saveUser(User user);
	User updateUser(User user);
	User getUserById(int userId);
	List<User> getUsers();

}
