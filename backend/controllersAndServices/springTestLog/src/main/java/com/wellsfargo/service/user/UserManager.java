package com.wellsfargo.service.user;

import java.util.List;

import com.wellsfargo.model.*;
//import User model
public interface UserManager {
	  void createUser(User user);
		
	  User getUserById(int userId);
		
	  User getUser(String username);
	  
	  User updateUser(int userId, User user);
		
	  List<User> getUsers();
}
