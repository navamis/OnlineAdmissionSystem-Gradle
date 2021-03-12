package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Branch;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.College;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Course;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Program;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.CollegeNotFoundException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.IBranchRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.ICollegeRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.ICourseRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.IProgramRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services.ICollegeService;



@Service
public class CollegeService implements ICollegeService {
//	static final Logger log = 
//	        LoggerFactory.getLogger(CollegeService.class);

	@Autowired
	ICollegeRepository collrepo;

	@Autowired
	IProgramRepository prorepo;
	
	@Autowired
	ICourseRepository courrepo;
	
	@Autowired
	IBranchRepository branrepo;
	
	@Override
	public College addCollege(College college) {
		collrepo.save(college);
		System.out.println(college);
		return college;
	}

	
	
	@Override
	public ArrayList<College> viewAllCollegeDetails() {
		ArrayList<College> col1 = new ArrayList<College>(collrepo.findAll());
		return col1;
	}



	@Override
	public College getCollegeDetailsByCollegeName(String collegeName) {
		College col5 = collrepo.findByCollegeName(collegeName);
	     return col5;
	}


	
	
	@Override
	public ArrayList<College> getCollegeDetailsByProgram(String programName) {
		Program program=prorepo.findByProgramName(programName);
		System.out.println(program);
		 ArrayList<College> col2 = collrepo.findByProgram(program);
		 System.out.println(col2);
	     return col2;
	}

	
	
	@Override
	public ArrayList<College> getCollegeDetailsByCourse(String courseName) {
		
		Course course = courrepo.findByCourseName(courseName);
		ArrayList<College> cor3 = collrepo.findByCourse(course);
		System.out.println(cor3);
	     return cor3;
	}

	
	
	@Override
	public ArrayList<College> getCollegeDetailsByBranch(String branchName) {
		
		Branch branch=branrepo.findByBranchName(branchName);
		ArrayList<College> barnc1 = collrepo.findByBranch(branch);
		System.out.println(barnc1);
	
	     return barnc1;
	}

	
	
	@Override
	public College deleteCollegeById(int collegeId) {
		 Optional<College> col6 = collrepo.findById(collegeId);
		 College c =col6.get();
	        if(col6.isPresent()) 
	        {
	        	
	            collrepo.delete(c);
	        } else {
	            throw new CollegeNotFoundException("No College record exist for given id");
	        }
	       return c; 
	    } 
		
	

	@Override
	public College deleteCollegeByName(String collegeName) {
	College col=collrepo.findByCollegeName(collegeName);
	College col1=col;
	collrepo.delete(col1);
	return col1;
	}

	
	
	@Override
	@Transactional
	public College updateCollegeDetails(College college) {
		System.out.println(college); 
		Optional<College> collpres = collrepo.findById(college.getCollegeRegId());
	        College college1=null; 
	        System.out.println(collpres.isPresent());
	        if(collpres.isPresent())
	        {
	            college1 = collpres.get();
	            college1.setCollegeName(college.getCollegeName());
	            collrepo.save(college1);
	        }    
	           return college1;
	       
	}

     



	
	
	@Override
	public College getCollegeDetailsByCollegeRegId(int collegeRegId) {
		College collpres1 = collrepo.findByCollegeRegId(collegeRegId);
		System.out.println(collpres1);
		return collpres1;
	}
	
	
}
