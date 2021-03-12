package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.User;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services.IUserService;

@RestController
public class UserController {
//	static final Logger log = 
//	        LoggerFactory.getLogger(UserController.class);
	@Autowired
	IUserService userService;
	
	
	@PostMapping("/users")
	@ResponseStatus(code = HttpStatus.CREATED) 
	public User addUserDetails(@RequestBody User user) {
		userService.addUserDetails(user);
		return user;
	}
	

	@GetMapping("/users")
	@ResponseStatus(code = HttpStatus.OK)
	public ArrayList<User> getAllUserDetails(){
		return (ArrayList<User>) userService.getAllUserDetails();
		}
	
	
	@GetMapping("/users/{userId}")
	@ResponseStatus(code = HttpStatus.OK)
	public User getUserDetailsById(@PathVariable int userId) {
		return userService.getUserDetailsById(userId);
		}
	
	@DeleteMapping("/users/{userId}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteUserDetailsById(@PathVariable int userId) {
		userService.deleteUserDetailsById(userId);
		//userService.deleteUserById(userId);
		}

	@PutMapping("/users") 
	@ResponseStatus(code = HttpStatus.OK)
	private User updateUserDetails(@RequestBody User user){
		userService.updateUserDetails(user);
		return user;  
		}
}