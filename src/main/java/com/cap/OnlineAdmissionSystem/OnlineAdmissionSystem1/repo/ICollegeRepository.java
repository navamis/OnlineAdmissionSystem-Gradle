package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo;

import java.util.ArrayList;

//import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Branch;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.College;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Course;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Program;


@Repository
public interface ICollegeRepository extends JpaRepository<College, Integer>  {
	
	ArrayList<College> findByCourse(Course course);

	ArrayList<College> findByProgram(Program program);

	ArrayList<College> findByBranch(Branch branch);

	College findByCollegeName(String collegeName);

	College findByCollegeRegId(int collegeRegId);

	

	//void deleteByCollegeName(String collegeName);

	

}
