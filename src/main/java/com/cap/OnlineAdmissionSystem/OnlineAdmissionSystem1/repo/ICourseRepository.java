package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo;
import java.util.ArrayList;
//import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Course;


	

	@Repository
	public interface ICourseRepository extends JpaRepository<Course,Integer>{

		public Course findByCourseName(String courseName);

		ArrayList<Course> findByEligibility(String eligibility);
        
	//	Course findByCoursename(String courseName);
//		Collection<? extends Course> findByCollegeName();


	}

