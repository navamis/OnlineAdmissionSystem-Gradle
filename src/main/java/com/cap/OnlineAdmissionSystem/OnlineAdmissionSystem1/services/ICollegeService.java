package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services;

import java.util.ArrayList;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.College;


public interface ICollegeService {


	
	public College addCollege(College college);
	public ArrayList<College> viewAllCollegeDetails();
	public  ArrayList<College> getCollegeDetailsByProgram(String programName);
	public  ArrayList<College> getCollegeDetailsByCourse(String courseName);
	public  ArrayList<College> getCollegeDetailsByBranch(String branchName);
	public  College getCollegeDetailsByCollegeName(String collgeName);
	public College deleteCollegeById(int collegeId);
	public College deleteCollegeByName(String collgeName);
	public College  updateCollegeDetails(College college);
	public  College getCollegeDetailsByCollegeRegId(int collegeRegId);
	//ArrayList<College> getCollegeDetailsByProgram(Program program);

}

