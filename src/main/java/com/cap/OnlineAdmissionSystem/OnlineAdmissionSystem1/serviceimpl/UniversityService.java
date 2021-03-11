package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.University;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.RecordNotFoundException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.IUniversityRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services.IUniversityServices;


@Service
public class UniversityService implements IUniversityServices {
	
	@Autowired
	IUniversityRepository unirepo;

	public University addUniversity(University university) {
//		University university=unirepo.
		unirepo.save(university);
		return university;
	}

	@Override
	public ArrayList<University> viewAllUniversityDetails() {
		ArrayList<University> uni1 = new ArrayList<University>(unirepo.findAll());
		return uni1;
	}
	     
	@Override
	public ArrayList<University> getUniversityDetailsByCity(String city) {
		 ArrayList<University> uni2 = unirepo.findByAddressCity(city);
	     return uni2;
	        
	}
	
	@Override
	public ArrayList<University> getUniversityDetailsBycollegeName(String collegeName) {
		ArrayList<University> uni3 = unirepo.findByCollegeCollegeName(collegeName);
	     return uni3;
	}

	@Override
	public void deleteUniversityById(int universityId) throws RecordNotFoundException  {
		{
			 Optional<University> uni4 = unirepo.findById(universityId);
	         
		        if(uni4.isPresent()) 
		        {
		            unirepo.deleteById(universityId);
		        } else {
		            throw new RecordNotFoundException("No employee record exist for given id");
		        }
		    } 
		}
	
	@Override
	public University getUniversityById(int applicationId) {
		Optional<University> uni5= unirepo.findById(applicationId);
		return uni5.get();
	}

	@Override
	public University updateUniversity(University university) {
		{
	        Optional<University> unipres = unirepo.findById(university.getUniversityid());
	         
	        if(unipres.isPresent()) 
	        {
	            University uninew = unipres.get();
	            uninew.setName(university.getName());
	            uninew.setAddress(university.getAddress());
	            uninew.setCollege(university.getCollege());
	           	
	            uninew = unirepo.save(uninew);
	             
	            return uninew;
	        } else {
	          university = unirepo.save(university);
	             
	            return university;
	        }
	    } 
     }

}