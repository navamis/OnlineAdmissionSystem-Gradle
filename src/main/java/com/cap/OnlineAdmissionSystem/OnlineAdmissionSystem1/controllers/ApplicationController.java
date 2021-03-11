package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Application;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl.ApplicationServiceImplementation;


@RestController
public class ApplicationController {
	
	@Autowired
	ApplicationServiceImplementation applicationServiceImplementation;
	

	@RequestMapping(value="/Application" , method = RequestMethod.GET)
	public ArrayList<Application> viewAllApplicationDetails(){
	 return	applicationServiceImplementation.viewAllApplicationDetails();
	}
	
	@RequestMapping(value="/Application/{email}" , method = RequestMethod.GET)
	public ArrayList<Application> getApplicationDetailsByEmail(@PathVariable("email")String email){
		return applicationServiceImplementation.getApplicationDetailsByEmail(email);
	}
	
	@RequestMapping(value="/Application" , method = RequestMethod.POST)
	public Application addApplication(@RequestBody Application application) {
		return applicationServiceImplementation.addApplication(application);
	}
	
	@RequestMapping(value="/ApplicationS/{Status}" , method = RequestMethod.GET)
	public ArrayList<Application> getApplicationDetailsByStatus(@PathVariable("Status")String status){
		return applicationServiceImplementation.getApplicationDetailsByStatus(status);
	}
	
	@RequestMapping(value="/ApplicationI/{Id}" , method = RequestMethod.DELETE)
	public int deleteApplicationById(@PathVariable("Id")int applicationId) {
		return applicationServiceImplementation.deleteApplicationById(applicationId);
	}
	
	@RequestMapping(value="/ApplicationE/{email}" , method = RequestMethod.DELETE)
	 public int deleteApplicationByEmail(@PathVariable("email")String email) {
		return applicationServiceImplementation.deleteApplicationByEmail(email);
	}
	@RequestMapping(value="/ApplicationI/{Id}" , method = RequestMethod.GET)
	public Application getApplicationById(@PathVariable("Id")int applicationId) {
		return applicationServiceImplementation.getApplicationById(applicationId);
	}
	@RequestMapping(value="/ApplicationU" , method = RequestMethod.POST)
	public int updateApplicationStatus(@RequestBody Application app) {
		return applicationServiceImplementation.updateApplicationStatus(app);
	}

	
}

