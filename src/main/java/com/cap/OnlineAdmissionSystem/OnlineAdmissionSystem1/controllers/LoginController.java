package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Login;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.User;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services.IUserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class LoginController {
	
	@Autowired
	IUserService  loginService;
	
	/* This method is for Adding Login Details
	 * @param Login
	 * @return login
	 */
	@PostMapping("/login")
	@Transactional
	@ApiOperation(value = "Add login details", response = Login.class)
	public ResponseEntity<Login> addLoginDetails(@ApiParam(value = "Add login details", required = true) @RequestBody Login login) {
		Login login1 = loginService.addLoginDetails(login);
		return new ResponseEntity<>(login1,HttpStatus.CREATED);
	}
//@PostMapping("/login")
//@ResponseStatus(code = HttpStatus.CREATED) 
//public void addLoginDetails(@RequestBody Login login) {
//	loginService.addLoginDetails(login);
//	}
	
	
	/*This method is for getting list of all login details
	 * @return ArrayList<Login>
	 */
	@GetMapping("/login")
	@ApiOperation(value = "Get all Login details",response= Login.class)
	public ResponseEntity<ArrayList<Login>> getAllLoginDetails(){
		ArrayList<Login> login = loginService.getAllLoginDetails();
		return new ResponseEntity<>(login,HttpStatus.OK);
	}	
//@GetMapping("/login")
//@ResponseStatus(code = HttpStatus.OK)
//public ArrayList<Login> getAllLoginDetails(){
//	return (ArrayList<Login>) loginService.getAllLoginDetails();
//	}
	
	
	/*This method is for getting Login details by userId
	 * @returns login
	 */
	@GetMapping("/login/{userId}")
	@ApiOperation(value = "get Login details by userId",response= Login.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Login> getLoginDetailsById(@PathVariable("userId") int userId){
		Login login = loginService.getLoginDetailsById(userId);
		return new ResponseEntity<>(login,HttpStatus.OK);
	}
//@GetMapping("/login/{userId}")
//@ResponseStatus(code = HttpStatus.OK)
//public Login getLoginDetailsById(@PathVariable int userId) {
//	return loginService.getLoginDetailsById(userId);
//	}
	
	
	/*This method is for deleting login details by userId
	 * @return String
	 */
	@DeleteMapping("/login/{userId}")
	@ApiOperation(value = "Delete login details by userId",notes = "Provide userId",response= Login.class)
	public ResponseEntity<String> deleteLogin(
	@ApiParam(value="Id of the user to be deleted",required = true) @PathVariable("userId") int userId) {
		loginService.deleteLoginDetailsById(userId);
		return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
	}
//@DeleteMapping("/login/{userId}")
//@ResponseStatus(code = HttpStatus.OK)
//public void deleteLoginDetailsById(@PathVariable int userId) {
//	loginService.deleteLoginDetailsById(userId);
//	//loginService.deleteLoginById(userId);
//	}
	
	
	/*This method is for changing the password by userId
	 * @return String
	 */
	@PutMapping("/loginchangePassword/{userId}")
	@ApiOperation(value = "Change Password",notes = "Provide userId",response= Login.class)
	public ResponseEntity<String> changePassword(
	@ApiParam(value="Id of the password to be changed",required = true) @RequestBody Login password) {
		loginService.changePassword(password);
		return new ResponseEntity<>("Successfully changed",HttpStatus.OK);
	}	
//@PutMapping("/loginchangePassword/{userId}") 
//@ResponseStatus(code = HttpStatus.OK)
//public Login changePassword(@RequestBody Login password){
//	loginService.changePassword(password);
//	return password;  
//	}

	
	/*This method is to reset the password by userId
	 * @return String
	 */
	@PutMapping("/loginresetPassword/{userId}")
	@ApiOperation(value = "reset Password",notes = "Provide userId",response= Login.class)
	public ResponseEntity<String> resetPassword(
	@ApiParam(value="Id of the password to be changed",required = true) @RequestBody Login password) {
		loginService.resetPassword(password);
		return new ResponseEntity<>("Reset successful",HttpStatus.OK);
	}		
//@PutMapping("/loginresetPassword/{userId}")
//@ResponseStatus(code = HttpStatus.OK)
//public Login resetPassword(@RequestBody Login password) {
//	loginService.resetPassword(password);
//	return password; 
//    }

}
	


