package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Course;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.AlreadyExistsException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.CourseNotFoundException;



@Component
public interface ICourseService {
	
	public Course addCourse(Course course) throws AlreadyExistsException;
	
	public ArrayList<Course> viewAllCourseDetails() throws CourseNotFoundException;
	
	public Course getCourseDetailsByCourseName(String courseName);
	
	public ArrayList<Course> getCourseDetailsByCollegeName(String collegeName);
	
	public ArrayList<Course> getCourseDetailsByEligibility(String eligibility);
	
	public Course getCourseDetailsByCourseId(int courseId);
	
	public int deleteCourseById(int courseId);
	
	public int deleteCourseByName(String courseName);
	
	public int updateCourseDetails(Course course);
	
}
