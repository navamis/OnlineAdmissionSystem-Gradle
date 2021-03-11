package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Program;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.AlreadyExistsException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.ProgramNotFoundException;


@Component
public interface IProgramService {
	
	public Program addProgram(Program program) throws AlreadyExistsException;
	
	public ArrayList<Program> viewAllProgramDetails() throws ProgramNotFoundException;
	
	public ArrayList<Program> getApplicationDetailsByCollegeName(String collegeName);
	
	public Program getProgramDetailsByName(String programName);
	
	public ArrayList<Program> getProgramDetailsByEligibility(String eligibility);
	
	public int deleteProgramById(int programId);
	
	public int deleteProgramByName(String programName);
	
	public Program getProgramById(int programId);
	
	public int updateProgramStatus(Program program);
	

}