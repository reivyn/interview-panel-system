package com.wellsfargo.interviews.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.interviews.service.user.UserManager;
import com.wellsfargo.interviews.model.*;
 //import USER Model
@CrossOrigin
@RestController
//@RequestMapping("/users")
public class UserRestController {

	
	
	
	@Autowired
	private UserManager userManager;

	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userManager.getUsers();
		return new ResponseEntity<>(users, HttpStatus.CREATED);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity getUser(@PathVariable("userId") int userId) {

		User user = userManager.getUserById(userId);
		if (user == null) {
			return new ResponseEntity<>("No User found for ID " + userId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	/*
	@GetMapping("/users/{userName}")
	public ResponseEntity getUserbyName(@PathVariable("userName") String userName) {

		String user = userManager.getUser(userName);
		if (user == null) {
			return new ResponseEntity<>("No User found for ID " + userName, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	*/
	
	@PostMapping(value = "/users")
	public ResponseEntity createUser(@RequestBody User user) {

		userManager.createUser(user);

		return new ResponseEntity(user, HttpStatus.OK);
	}
/*
	@DeleteMapping("/users/{userId}")
	public ResponseEntity deleteUser(@PathVariable Long userId) {

		if (null == userManager.delete(userId)) {
			return new ResponseEntity("No User found for ID " + userId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(userId, HttpStatus.OK);

	}
	*/

	@PutMapping("/users/{userId}")
	public ResponseEntity updateUser(@PathVariable int userId, @RequestBody User user) {
		
		user = userManager.updateUser(userId, user);

		if (null == user) {
			return new ResponseEntity("No User found for ID " + userId, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(user, HttpStatus.OK);
	}

}