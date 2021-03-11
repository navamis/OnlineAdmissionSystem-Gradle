package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.controllers;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Program;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.AlreadyExistsException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.ProgramNotFoundException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl.ProgramServiceImplementation;


@RestController
@RequestMapping(path = "/api/v1")
public class ProgramController {

	@Autowired
	ProgramServiceImplementation programServiceImplementation;
	
	@PostMapping("/programs")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Program addProgram(@RequestBody Program program) throws AlreadyExistsException {
		programServiceImplementation.addProgram(program);
		return program;
	}
	
	@GetMapping("/programs")
	@ResponseStatus(code = HttpStatus.OK)
	public ArrayList<Program> viewAllProgramDetails() throws ProgramNotFoundException {
		return programServiceImplementation.viewAllProgramDetails();
	}
	
	@GetMapping("/programByCollegeName/{collegeName}")
	@ResponseStatus(code = HttpStatus.OK)
	public ArrayList<Program> getApplicationDetailsByCollegeName(@PathVariable("collegeName") String collegeName){
		return programServiceImplementation.getApplicationDetailsByCollegeName(collegeName);
	}
	
	@GetMapping("/programByProgramName/{programName}")
	@ResponseStatus(code = HttpStatus.OK)
	public Program getProgramDetailsByName(@PathVariable("programName")String programName) {
		return programServiceImplementation.getProgramDetailsByName(programName);
	}
	
	@GetMapping("/programByEligibility/{eligibility}")
	@ResponseStatus(code = HttpStatus.OK)
	public ArrayList<Program> getProgramDetailsByEligibility(@PathVariable("eligibility") String eligibility) {
		return programServiceImplementation.getProgramDetailsByEligibility(eligibility);
	}

	@DeleteMapping("/deleteProgramById/{programId}")
	@ResponseStatus(code = HttpStatus.OK)
	public int deleteProgramById(@PathVariable("programId") int programId) {
		return programServiceImplementation.deleteProgramById(programId);
	}
	
	@DeleteMapping("/deleteProgramByName/{programName}")
	@ResponseStatus(code = HttpStatus.OK)
	public int deleteProgramByName(@PathVariable("programName") String programName) {
		return programServiceImplementation.deleteProgramByName(programName);
	}
	
	@GetMapping("/programById/{programId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Program getProgramById(@PathVariable("programId") int programId) {
		return programServiceImplementation.getProgramById(programId);
	}
	
	@PutMapping("/programs/{programId}")
	@ResponseStatus(code = HttpStatus.OK)
	@Transactional
	public int updateProgramStatus(@RequestBody Program program,@PathVariable("programId") int programId) {
		return programServiceImplementation.updateProgramStatus(program);
	}
}
