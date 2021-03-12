package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.College;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.ProgramScheduled;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.IProgramScheduleRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl.CollegeService;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl.ProgramScheduledServiceImplementation;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/api/v1")
public class ProgramScheduleController {
//	static final Logger log = 
//	        LoggerFactory.getLogger(ProgramScheduleController.class);

	/*
	 * add @return values and @param if needed
	 */
	@Autowired
	CollegeService collegeService;
	@Autowired
	IProgramScheduleRepository programScheduleRepository;
	@Autowired
	ProgramScheduledServiceImplementation programScheduledServiceImplementation;
	

//	@PostMapping("/programSchedules")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public ProgramScheduled addProgramSchedule(@RequestBody ProgramScheduled programSchedule) {
//		programScheduledServiceImplementation.addProgramSchedule(programSchedule);
//		return programSchedule;
//	}
	/*
	 * This method adds college
	 * 
	 */
	@PostMapping("/programScheduled")
	@Transactional
	@ApiOperation(value = "Add ProgramScheduled", response = ProgramScheduled.class)
	public ResponseEntity<ProgramScheduled> addProgramSchedule(@ApiParam(value = "Add ProgramScheduled", required = true) @RequestBody ProgramScheduled pS) {
		ProgramScheduled programScheduled = programScheduledServiceImplementation.addProgramSchedule(pS);
		return new ResponseEntity<>(programScheduled ,HttpStatus.CREATED);
	}
	
//	@GetMapping("/programSchedules")
//	@ResponseStatus(code = HttpStatus.OK)
//	public ArrayList<ProgramScheduled> viewAllProgramScheduleDetails() {
//		return programScheduledServiceImplementation.viewAllProgramScheduleDetails();
//	}
	
	/*
	 * Method to view all college Details
	 */
	@GetMapping("/programScheduled")
	@ApiOperation(value = "View All ProgramScheduled Details",response= ProgramScheduled.class)
	public ResponseEntity<ArrayList<ProgramScheduled>> viewAllProgramScheduleDetails(){
		ArrayList<ProgramScheduled> programScheduled = programScheduledServiceImplementation.viewAllProgramScheduleDetails();
		return new ResponseEntity<>(programScheduled,HttpStatus.OK);
	}
	
//	@GetMapping("/programScheduleByName/{collegeName}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public College getProgramScheduleByCollegeName(@PathVariable("collegeName") String collegeName) {
//		return programScheduledServiceImplementation.getProgramScheduleByCollegeName(collegeName);
//	}
	
	/*
	 * This method gets Program details by college name
	 */
	@GetMapping("/programScheduled/getprogramScheduled/{collegeName}")
	@ApiOperation(value = "get ProgramScheduled details by college name",response= College.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ProgramScheduled> getProgramScheduleByCollegeName(@PathVariable("collegeName") String collegeName){
		programScheduledServiceImplementation.getProgramScheduleByCollegeName(collegeName);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@GetMapping("/programScheduleByDate/{date}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public List<ProgramScheduled> getProgramScheduleByDate(@PathVariable("date") LocalDate date) {
//		return programScheduledServiceImplementation.getProgramScheduleByDate(date);
//	}
	
	/*
	 * this method gets programSchedule details By Date
	 * @returns programSchedule
	 */
	@GetMapping("/programScheduledByDate/{date}")
	@ApiOperation(value = "get ProgramScheduled details by date",response= ProgramScheduled.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ProgramScheduled> getProgramScheduleByDate(@PathVariable("date") LocalDate date){
		ProgramScheduled pS = (ProgramScheduled) programScheduledServiceImplementation.getProgramScheduleByDate(date);
		return new ResponseEntity<>(pS,HttpStatus.OK);
	}
	
//	@DeleteMapping("/deleteProgramScheduledById/{scheduleId}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public int deleteProgramScheduleById(@PathVariable("scheduleId") int scheduleId) {
//		return programScheduledServiceImplementation.deleteProgramScheduleById(scheduleId);
//	}
	
	/*
	 * This method delete's delete ProgramScheduled By Id
	 * @returns programSchedule
	 */	
	@DeleteMapping("/deleteProgramScheduledById/{scheduleId}")
	@ApiOperation(value = "Delete ProgramScheduled by scheduleId",notes = "Provide scheduleId",response= ProgramScheduled.class)
	public ResponseEntity<String> deleteProgramScheduleById(
	@ApiParam(value="Name of the college to be deleted",required = true) @PathVariable("scheduleId") int scheduleId) {
		programScheduledServiceImplementation.deleteProgramScheduleById(scheduleId);
		return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
	}
	
//	@GetMapping("/programScheduleById/{scheduleId}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public ProgramScheduled getProgramScheduleById(@PathVariable("scheduleId") int scheduleId) {
//		return programScheduledServiceImplementation.getProgramScheduleById(scheduleId);
//	}
	/*
	 * this method gets programSchedule details By scheduleId
	 * @returns programSchedule
	 */
	@GetMapping("/programScheduledById/{scheduleId}")
	@ApiOperation(value = "get ProgramScheduled details by scheduleId",response= ProgramScheduled.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ProgramScheduled> getProgramScheduleByDate(@PathVariable("scheduleId") int scheduleId){
		ProgramScheduled pS = (ProgramScheduled) programScheduledServiceImplementation.getProgramScheduleById(scheduleId);
		return new ResponseEntity<>(pS,HttpStatus.OK);
	}

//	@PutMapping("/programSchedules/{scheduleId}")
//	@ResponseStatus(code = HttpStatus.OK)
//	@Transactional
//	public int updateProgramSchedule(@RequestBody ProgramScheduled programSchedule,@PathVariable("scheduleId") int scheduleId) {
//		return programScheduledServiceImplementation.updateProgramSchedule(programSchedule);
//	}
	
	/*
	 * This method updates programSchedules details by scheduleId
	 */
	@PutMapping("/programScheduled/{scheduleId}")
	@ApiOperation(value = "update programScheduled details",notes = "Provide scheduleId",response= ProgramScheduled.class)
	public ResponseEntity<String> updateProgramSchedule(
	@ApiParam(value="RegId of tht ProgramScheduled to be updated",required = true) @RequestBody ProgramScheduled programScheduled,@PathVariable("scheduleId") int scheduleId) {
		programScheduledServiceImplementation.updateProgramSchedule(programScheduled);
		return new ResponseEntity<>("update successful",HttpStatus.OK);
	}
}