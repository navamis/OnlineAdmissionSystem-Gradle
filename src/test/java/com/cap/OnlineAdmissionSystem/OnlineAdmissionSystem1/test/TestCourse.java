package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.test;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Branch;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Course;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.AlreadyExistsException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.CourseNotFoundException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl.CourseServiceImplementation;


@SpringBootTest
class TestCourse {

//	College college;
	ArrayList<Branch> branch;
	
	@Autowired
	CourseServiceImplementation courseServiceImplementation;
	
	@BeforeEach
	void setUp() {
//		college=new College("Presidency University");
		Branch b1=new Branch("Mech","Machines");
		Branch b2=new Branch("Electronics","Circuits");
		ArrayList<Branch> branch=new ArrayList<Branch>();
		branch.add(b1);
		branch.add(b2);
		Course course=new Course();
		course.setCourseId(1);
		course.setCourseName("B tech");
		course.setEligibility("Passed 10+2");
		course.setBranches(branch);
	}

	@Test
	@Transactional
	public void testAddCourse() throws AlreadyExistsException {
		try {
			Branch b1= new Branch("mech", "Computer Science Engineering");
			Branch b2= new Branch("civil","Electronics communication engineering");
			ArrayList<Branch> branches= new ArrayList<Branch>();
			  branches.add(b1);
			  branches.add(b2);

            Course c1=new Course("C++", "7 cgpa",branches);
			Course course1=courseServiceImplementation.addCourse(c1);	
			System.out.println(course1);
		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testViewAllCourseDetails() throws CourseNotFoundException {
		courseServiceImplementation.viewAllCourseDetails();
	}
	
//	@Test
	public void testGetCourseDetailsByCourseName() {
		String name="B Tech";
	    courseServiceImplementation.getCourseDetailsByCourseName(name);
	}
	
//	@Test
	public void testGetCourseDetailsByEligibility() {
		String eligibility="Passed 10+2";
		ArrayList<Course> course=courseServiceImplementation.getCourseDetailsByEligibility(eligibility);
		System.out.println(course);
	}
	
//	@Test
	public void testGetCourseDetailsByCourseId() {
		int id=3;
		Course course=courseServiceImplementation.getCourseDetailsByCourseId(id);
		System.out.println(course);
	}
	
//	@Test
	public void testDeleteCourseById() {
		int id=3;
		courseServiceImplementation.deleteCourseById(id);
		System.out.println("Course deleted");
	}
	
//	@Test
	public void testDeleteCourseByName() {
		String name="B Tech";
		courseServiceImplementation.deleteCourseByName(name);
		System.out.println("Course deleted");
	}
	
//	@Test
	public void testUpdateCourseDetails() {
		Course course=new Course("MS","B Tech",branch);
		courseServiceImplementation.updateCourseDetails(course);
		System.out.println("Course updated");
	}

}
