package com.wellsfargo.interviews.service.user;

import java.util.List;

import com.wellsfargo.interviews.model.*;
//import User model
public interface UserManager {
	  void createUser(User user);
		
	  User getUserById(int userId);
		
	  //User getUser(String username);
	  
	  User updateUser(int userId, User user);
		
	  List<User> getUsers();
}
