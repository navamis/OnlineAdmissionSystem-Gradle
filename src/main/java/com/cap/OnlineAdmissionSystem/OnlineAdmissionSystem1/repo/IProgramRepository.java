package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo;



import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Program;



@Repository
public interface IProgramRepository extends JpaRepository<Program, Integer>{

	Program findByProgramName(String programName);

	ArrayList<Program> findByEligibility(String eligibility);
	
	

}