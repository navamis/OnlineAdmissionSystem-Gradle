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
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.ICollegeRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services.ICollegeService;


@SpringBootTest
public class CollegeTest {


		@Autowired
		ICollegeRepository collressrepository;
		
		@Autowired
		ICollegeService collservice;
		
		College college;
		
		
		public void setUp() {
			System.out.println("before every test case....");
						
		}
        
       
       
      

		@Test
		public void Testaddcollege()
		{
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
		    
            
		    
		    college= new College("BMSIT",address ,programs,courses,branches);
			
			collservice.addCollege(college);
			
		}
		
		
		
		//@Test
		public void TestviewAllCollegeDetails()
		{
			collservice.viewAllCollegeDetails();
		}
		
		
		
		//@Test
		public void TestgetCollegeDetailsByName()
		{
			collservice.getCollegeDetailsByCollegeName("Reva");
		}
		
		
		
//		@Test
		public void TestdeleteCollegeById() {
			collservice.deleteCollegeById(6);
		}
		
		
		
		//@Test
		public void TestdeleteCollegeByName() {
			collservice.deleteCollegeByName("Presi");
		}
		
		
		
		//@Test
		public void TestupdateCollegeDetails()
		{
			
		College col=collservice.getCollegeDetailsByCollegeRegId(1);
		col.setCollegeName("Presidency");
		collservice.updateCollegeDetails(col);
			
		}
		
		
		
	//	@Test
		public void TestgetCollegeDetailsById()
		{
			collservice.getCollegeDetailsByCollegeRegId(1);
		}
		
		
	
	//	@Test
		public void getCollegeDetailsByProgram()
		{
			collservice.getCollegeDetailsByProgram("B.tech");
		}
		
		
		
		//@Test
		public void getCollegeDetailsByBranch()
		{
			collservice.getCollegeDetailsByBranch("CSE");
		}
		
		
		
		//@Test
		public void getCollegeDetailsByCourse()
		{
			collservice.getCollegeDetailsByCourse("C");
		}
		
}
