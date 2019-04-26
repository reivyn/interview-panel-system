package com.wellsfargo.service.user.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.service.user.UserManager;
//import USER DAO 
// import USER MODEL
@Service
public class UserManagerImpl implements UserManager {

	 @Resource
	  private UserDAO userDAO;
	
	
	
	
	  @Override
	  @Transactional
	  public void createUser(User user) {
	    userDAO.insertUser(user);
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
		  return userDAO.updateUser(user);
	  }
	  
	  @Override
	  @Transactional
	  public List<User> getUsers() {
	    return userDAO.getUsers();
	  }

}
