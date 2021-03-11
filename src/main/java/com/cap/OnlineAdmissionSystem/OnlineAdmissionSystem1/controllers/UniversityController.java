package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Login;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.University;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl.UniversityService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/*
 * notes = "Provide userId"?????????(update university by what)
 * @ApiParam check value
 * check response entity in get Mapping
 */

@RestController
public class UniversityController {
	
	@Autowired
	UniversityService universityService;
	
//	@PostMapping("/addUniversity")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public University addUniversity(@RequestBody University u) {
//		return universityService.addUniversity(u);
//	}
	
	/*
	 * This method adds University
	 * @param University
	 * @return university
	 */	
	@PostMapping("/addUniversity")
	@Transactional
	@ApiOperation(value = "Add University", response = University.class)
	public ResponseEntity<University> addUniversity(@ApiParam(value = "Add University", required = true) @RequestBody University university) {
		University university1 = universityService.addUniversity(university);
		return new ResponseEntity<>(university1,HttpStatus.CREATED);
	}	
	
	
//	@PutMapping("/updateUniversity")
//	@ResponseStatus(code = HttpStatus.OK)
//	@Transactional
//	public University updateUniversity(@RequestBody University u) {
//		return universityService.updateUniversity(u);
//	}
	
	/*
	 * This method updates University
	 * @param University
	 * @return university
	 */
	@PutMapping("/updateUniversity")
	@ApiOperation(value = "Update University",response= University.class)
	public ResponseEntity<String> updateUniversity(
	@ApiParam(value="Id of the password to be changed",required = true) @RequestBody University u) {
		universityService.updateUniversity(u);
		return new ResponseEntity<>("Successfully changed",HttpStatus.OK);
	}	
	
	
//	@DeleteMapping("/deleteUniversity/{Id}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public void deleteUniversity(@PathVariable("id") int id) {
//		universityService.deleteUniversityById(id);
//	}
	
	/*
	 * This method delete's University by Id
	 * @return String
	 */
	@DeleteMapping("/deleteUniversity/{Id}")
	@ApiOperation(value = "Delete University by Id",notes = "Provide Id",response= University.class)
	public ResponseEntity<String> deleteUniversity(
	@ApiParam(value="Id of the university to be deleted",required = true) @PathVariable("id") int id) {
		universityService.deleteUniversityById(id);
		return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
	}

	
//	@GetMapping("/viewAllUniversity")
//	@ResponseStatus(code = HttpStatus.OK)
//	public List<University> viewAllUniversityDetails() {
//		return universityService.viewAllUniversityDetails();
//	}
	
	/*
	 * Method to view all University details
	 * @return university
	 */	
	@GetMapping("/viewAllUniversity")
	@ApiOperation(value = "View all University details",response= University.class)
	public ResponseEntity<List<University>> viewAllUniversityDetails(){
		List<University> university = universityService.viewAllUniversityDetails();
		return new ResponseEntity<>(university,HttpStatus.OK);
	}	
	
	
//	@GetMapping("/viewIDUniversity/{Id}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public University getUniversityById(@PathVariable("Id") int Id) {
//		return universityService.getUniversityById(Id);
//	}
	
	/*
	 * This method gets University by Id
	 * @return university
	 */
	@GetMapping("/viewIDUniversity/{Id}")
	@ApiOperation(value = "get University by Id",response= University.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<University> getUniversityById(@PathVariable("Id") int Id){
		University university =  universityService.getUniversityById(Id);
		return new ResponseEntity<>(university,HttpStatus.OK);
	}
	
	
//	@GetMapping("/viewCityUniversity/{city}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public ArrayList<University> getUniversityByCity(@PathVariable("city") String city) {
//		return universityService.getUniversityDetailsByCity(city);
//	}
	
	/*
	 * This method gets University by city
	 * @return university
	 */
	@GetMapping("/viewCityUniversity/{city}")
	@ApiOperation(value = "get University by city",response= University.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ArrayList<University>> getUniversityByCity(@PathVariable("city") String city){
		ArrayList<University> university = universityService.getUniversityDetailsByCity(city);
		return new ResponseEntity<>(university,HttpStatus.OK);
	}
	
	
//	@GetMapping("/viewCityUniversity/{collegeName}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public ArrayList<University> getUniversityByCollege(@PathVariable("collegeName")String collegeName) {
//		return universityService. getUniversityDetailsBycollegeName(collegeName);
//}
	
	/*
	 * This method gets University by college name
	 * @return university
	 */
	@GetMapping("/viewCityUniversity/{collegeName}")
	@ApiOperation(value = "get University by college name",response= University.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ArrayList<University>> getUniversityByCollege(@PathVariable("collegeName")String collegeName){
		ArrayList<University> university = universityService. getUniversityDetailsBycollegeName(collegeName);
		return new ResponseEntity<>(university,HttpStatus.OK);
	}
}