package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.College;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.ProgramScheduled;


@Component
public interface IProgramScheduleService {
	
	public ProgramScheduled addProgramSchedule(ProgramScheduled programschedule);
	
	public ArrayList<ProgramScheduled> viewAllProgramScheduleDetails();
	
	public College getProgramScheduleByCollegeName(String collegeName);
	
	public List<ProgramScheduled> getProgramScheduleByDate(LocalDate date);
	
	public int deleteProgramScheduleById(int scheduleId);
	
	public ProgramScheduled getProgramScheduleById(int scheduleId);
	
	public int updateProgramSchedule(ProgramScheduled programSchedule);

}
