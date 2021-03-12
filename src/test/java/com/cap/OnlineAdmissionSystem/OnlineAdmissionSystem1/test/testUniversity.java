package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Address;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Branch;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.College;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Course;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Program;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.University;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl.UniversityService;


@SpringBootTest
class testUniversity {
	
	Address address;
	University university;
	
	@Autowired
	UniversityService universityService;

	//University university1=new University("Presii",address,null);
	
	//@Test
	void testaddUniversity() {
		Branch b1= new Branch("mech", "Computer Science Engineering");
		Branch b2= new Branch("civil","Electronics communication engineering");
		ArrayList<Branch> branches= new ArrayList<Branch>();
		  branches.add(b1);
		  branches.add(b2);
		  
	   Program p1=new Program("M.tech", "70% abv", "4 years", "Graduation");
		    ArrayList<Program> programs= new ArrayList<Program>();
		    programs.add(p1);
		    
	   Address address= new Address("abc","defg","vvv","hij",890,"klmnop");
		  
	    Course c1=new Course("C++", "7 cgpa",branches);
	    ArrayList<Course> courses= new ArrayList<Course>();
	    courses.add(c1);
	    
        
	    
	  College college= new College("BMSIT",address ,programs,courses,branches);
	  ArrayList<College> c=new ArrayList<College>();
	  c.add(college);
		
//		Address address1=new Address("abcsf","defjjkkbbbbg","vhhhvv","hjjij",8900,"klmnkkkop");
		University university=new University("Presi",address,c);
		//University university2=new University("GLA",address,null);
		universityService.addUniversity(university);
		//universityService.addUniversity(university2);
	}
	
	//@Test
	void testviewAllUniversityDetails()
	{
		
		ArrayList<University> university=universityService.viewAllUniversityDetails();
		System.out.println(university);
	}
	
//	@Test
	void testgetUniversityById()
	{
		University university=universityService.getUniversityById(1);
		System.out.println(university);
	}
	
//	@Test
	void testupdateUniversity()
	{
		University university1=universityService.updateUniversity(university);
		System.out.println(university1);
	}
	
//	@Test
	void getUniversityDetailsByCity()
	{
		University university1=universityService.updateUniversity(university);
		System.out.println(university1);
	}
	
//	@Test
	void deleteUniversity()
	{
		universityService.deleteUniversityById(1);
	}

}
