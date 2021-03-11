package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.controllers;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Course;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.AlreadyExistsException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.CourseNotFoundException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl.BranchServiceImplementation;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl.CourseServiceImplementation;


@RestController
@RequestMapping(path = "/api/v1")
public class CourseController {
	
	@Autowired
	CourseServiceImplementation courseServiceImplementation;
	
	@Autowired
	BranchServiceImplementation branchServiceImplementation;

	@PostMapping("/courses")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Course addCourse(@RequestBody Course course) throws AlreadyExistsException {
		courseServiceImplementation.addCourse(course);
		return course;
	}
	
	@GetMapping("/courses")
	@ResponseStatus(code = HttpStatus.OK)
	public ArrayList<Course> viewAllCourseDetails() throws CourseNotFoundException {
		return courseServiceImplementation.viewAllCourseDetails();
	}
	
	@GetMapping("/courseByName/{courseName}")
	@ResponseStatus(code = HttpStatus.OK)
	public Course getCourseDetailsByCourseName(@PathVariable("courseName") String courseName) {
		return courseServiceImplementation.getCourseDetailsByCourseName(courseName);
	}
	
	@GetMapping("/courseByCollegeName/{collegeName}")
	@ResponseStatus(code = HttpStatus.OK)
	public ArrayList<Course> getCourseDetailsByCollegeName(@PathVariable("collegeName") String collegeName) {
//		return courseServiceImplementation.getCourseDetailsByCollegeName(collegeName);
		return null;
	}
	
	@GetMapping("/courseByEligibility/{eligibility}")
	@ResponseStatus(code = HttpStatus.OK)
	public ArrayList<Course> getCourseDetailsByEligibility(@PathVariable("eligibility") String eligibility) {
		return courseServiceImplementation.getCourseDetailsByEligibility(eligibility);
	}
	
	@GetMapping("/courseById/{courseId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Course getCourseDetailsByCourseId(@PathVariable("courseId") int courseId) {
		return courseServiceImplementation.getCourseDetailsByCourseId(courseId);
	}
	
	@DeleteMapping("/deleteCourseById/{courseId}")
	@ResponseStatus(code = HttpStatus.OK)
	public int deleteCourseById(@PathVariable("courseId") int courseId) {
		return courseServiceImplementation.deleteCourseById(courseId);
	}
	
	@DeleteMapping("/deleteCourseByCourseName/{courseName}")
	@ResponseStatus(code = HttpStatus.OK)
	public int deleteCourseByName(@PathVariable("courseName") String courseName) {
		return courseServiceImplementation.deleteCourseByName(courseName);
	}
	
	@PutMapping("/courses/{courseId}")
	@ResponseStatus(code = HttpStatus.OK)
	@Transactional
	public int updateCourseDetails(@RequestBody Course course,@PathVariable("courseId") int courseId) {
		return courseServiceImplementation.updateCourseDetails(course);
	}
}
