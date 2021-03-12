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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.College;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.ICollegeRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl.CollegeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/api/v1")
public class CollegeController {
//	static final Logger log = 
//	        LoggerFactory.getLogger(CollegeController.class);
	
	/*
	 * add @return values and @param if needed
	 */
	@Autowired
	ICollegeRepository collegerepository;
	
	@Autowired
	CollegeService collegeservice;

//	@PostMapping("/collegeadd")
//	@ResponseStatus(code = HttpStatus.CREATED) 
//	public College addCollege(@RequestBody College c) 
//	{
//		return collegeservice.addCollege(c);
//		
//	}
	
	/*
	 * This method adds college
	 * 
	 */
	@PostMapping("/collegeadd")
	@Transactional
	@ApiOperation(value = "Add College", response = College.class)
	public ResponseEntity<College> addCollege(@ApiParam(value = "Add College", required = true) @RequestBody College c) {
		College coll1 = collegeservice.addCollege(c);
		return new ResponseEntity<>(coll1 ,HttpStatus.CREATED);
	}
	
//	@GetMapping("/collegeview")
//	@ResponseStatus(code = HttpStatus.OK)
//	public ArrayList<College> viewAllCollegeDetails()
//	{
//		return collegeservice.viewAllCollegeDetails();
//	}
	
	/*
	 * Method to view all college Details
	 */
	@GetMapping("/collegeview")
	@ApiOperation(value = "View All College Details",response= College.class)
	public ResponseEntity<ArrayList<College>> viewAllCollegeDetails(){
		ArrayList<College> coll = collegeservice.viewAllCollegeDetails();
		return new ResponseEntity<>(coll,HttpStatus.OK);
	}	
	
//	@GetMapping("/college/getcollege/{collegeName}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public College getCollegeDetailsByCollegeName(@PathVariable("collegeName") String collegeName)
//	{
//		return collegeservice.getCollegeDetailsByCollegeName(collegeName);
//	}
	
	/*
	 * This method gets college details by college name
	 */
	@GetMapping("/college/getcollege/{collegeName}")
	@ApiOperation(value = "get college details by college name",response= College.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<College> getCollegeDetailsByCollegeName(@PathVariable("collegeName") String collegeName){
		College coll = collegeservice.getCollegeDetailsByCollegeName(collegeName);
		return new ResponseEntity<>(coll,HttpStatus.OK);
	}
	
	
	
//	@DeleteMapping("/collegeid/{collegeRegId}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public void deleteCollegeById(@PathVariable("collegeRegId")int collegeRegId)
//	{
//		collegeservice.deleteCollegeById(collegeRegId);
//	}
	
	/*
	 * This method delete's college by id
	 * @return String
	 */
	@DeleteMapping("/collegeid/{collegeRegId}")
	@ApiOperation(value = "Delete college by Id",notes = "Provide collegeRegId",response= College.class)
	public ResponseEntity<String> deleteCollegeById(
	@ApiParam(value="Id of the college to be deleted",required = true)@PathVariable("collegeRegId")int collegeRegId) {
		collegeservice.deleteCollegeById(collegeRegId);
		return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
	}
	
	
	
//	@DeleteMapping("/collegename/{collegeName}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public void deleteCollegeByName(@PathVariable("collegeName") String collegeName)
//	{
//		collegeservice.deleteCollegeByName(collegeName);
//	}
	
	/*
	 * This method delete's college by college name
	 * @returns String
	 */	
	@DeleteMapping("/collegename/{collegeName}")
	@ApiOperation(value = "Delete college by college name",notes = "Provide collegeName",response= College.class)
	public ResponseEntity<String> deleteCollegeByCollegeName(
	@ApiParam(value="Name of the college to be deleted",required = true) @PathVariable("collegeName") String collegeName) {
		collegeservice.deleteCollegeByName(collegeName);
		return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
	}
	
	
	
//	@PutMapping("/collegedetails/{collegeRegId}")
//	@ResponseStatus(code = HttpStatus.OK)
//	@Transactional
//	public College updateCollegeDetails(@RequestBody College college,@PathVariable("collegeRegId") int collegeRegId) {
//		return collegeservice.updateCollegeDetails(college);
//	}
	/*
	 * This method updates college details by college Id
	 */
	@PutMapping("/collegedetails/{collegeRegId}")
	@ApiOperation(value = "update college details",notes = "Provide collegeRegId",response= College.class)
	public ResponseEntity<String> updateCollegeDetails(
	@ApiParam(value="RegId of the college to be updated",required = true) @RequestBody College college,@PathVariable("collegeRegId") int collegeRegId) {
	    collegeservice.updateCollegeDetails(college);
		return new ResponseEntity<>("update successful",HttpStatus.OK);
	}
	
	
	
//	@GetMapping("/collegebyid/{collegeRegId}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public College getCollegeDetailsByCollegeRegId(@PathVariable("collegeRegId") int collegeRegId)
//	{
//		return collegeservice.getCollegeDetailsByCollegeRegId(collegeRegId);
//	}
	/*
	 * this method gets college details by college regId
	 * @returns college
	 */
	@GetMapping("/collegebyid/{collegeRegId}")
	@ApiOperation(value = "get college details by college RegId",response= College.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<College> getCollegeDetailsByCollegeRegId(@PathVariable("collegeRegId") int collegeRegId){
		College coll = collegeservice.getCollegeDetailsByCollegeRegId(collegeRegId);
		return new ResponseEntity<>(coll,HttpStatus.OK);
	}
	
//	
//	@GetMapping("/collegeprogram/{programName}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public ArrayList<College> getCollegeDetailsByProgram(@PathVariable("programName") String programName)
//	{
//		System.out.println(programName);
//		return collegeservice.getCollegeDetailsByProgram(programName);
//	}
	/*
	 *This method gets college details by program 
	 *@return college 
	 */
	@GetMapping("/collegeprogram/{programName}")
	@ApiOperation(value = "get college details by program",response= College.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ArrayList<College>>getCollegeDetailsByProgram(@PathVariable("programName") String programName){
		ArrayList<College> coll = collegeservice.getCollegeDetailsByProgram(programName);
		return new ResponseEntity<>(coll,HttpStatus.OK);
	}
	
	
//	@GetMapping("/collegecourse/{courseName}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public ArrayList<College> getCollegeDetailsByCourse(@PathVariable("courseName") String courseName)
//	{
//		System.out.println(courseName);
//		return collegeservice.getCollegeDetailsByCourse(courseName);
//	}
	/*
	 * This method gets college details by course name
	 * @return college
	 * 
	 */
	@GetMapping("/collegecourse/{courseName}")
	@ApiOperation(value = "get college details by course name",response= College.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ArrayList<College>> getCollegeDetailsByCourse(@PathVariable("courseName") String courseName){
		ArrayList<College> coll = collegeservice.getCollegeDetailsByCourse(courseName);
		return new ResponseEntity<>(coll,HttpStatus.OK);
	}
	
//	@GetMapping("/collegebranch/{branchName}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public ArrayList<College> getCollegeDetailsByBranch(@PathVariable("branchName") String branchName)
//	{
//		System.out.println(branchName);
//		return collegeservice.getCollegeDetailsByBranch(branchName);
//	}	
	/*
	 *This method gets college details by branch
	 *@return college 
	 */
	@GetMapping("/collegebranch/{branchName}")
	@ApiOperation(value = "get college details by branch",response= College.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ArrayList<College>>getCollegeDetailsByBranch(@PathVariable("branchName") String branchName){
		ArrayList<College> coll = collegeservice.getCollegeDetailsByBranch(branchName);
		return new ResponseEntity<>(coll,HttpStatus.OK);
	}
}
