package com.wellsfargo.service.user.impl;
import com.wellsfargo.dao.*;
import com.wellsfargo.model.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.service.user.UserManager;
//import USER DAO 
// import USER MODEL
@Service
public class UserManagerImpl implements UserManager {

		@Autowired
	  private UserDAO userDAO;
	
	
	
	
	  @Override
	  @Transactional
	  public void createUser(User user) {
	    userDAO.add(user);;
	  }
	  
	

	  @Override
	  @Transactional
	  public User getUserById(int userId) {
	    return userDAO.getUserById(userId);
	  }
	  
	  @Override
	  @Transactional
	  public User getUser(String username) {
	    return userDAO.getUser(username);
	  }
	  
	  @Override
	  @Transactional
	  public User updateUser(int userId, User user) {
		  return null;
		// return userDAO.updateUser(userId ,user);
	  }
	  
	  @Override
	  @Transactional
	  public List<User> getUsers() {
	    return userDAO.getUsers();
	  }

}
