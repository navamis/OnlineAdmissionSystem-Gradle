package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.College;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.ProgramScheduled;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.ICollegeRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.IProgramScheduleRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services.IProgramScheduleService;

@Service
public class ProgramScheduledServiceImplementation implements IProgramScheduleService {
	
	@Autowired
	IProgramScheduleRepository programScheduleRepository;
	
	@Autowired
	ICollegeRepository collegeRepository;

	@Override
	public ProgramScheduled addProgramSchedule(ProgramScheduled programSchedule) {
		programScheduleRepository.save(programSchedule);
		return programSchedule;
	}

	@Override
	public ArrayList<ProgramScheduled> viewAllProgramScheduleDetails() {
		ArrayList<ProgramScheduled> programs = new ArrayList<ProgramScheduled>(programScheduleRepository.findAll());
		return programs;
	}

	@Override
	public College getProgramScheduleByCollegeName(String collegeName) {
		College college = collegeRepository.findByCollegeName(collegeName);
		return college;
	}

	@Override
	public List<ProgramScheduled> getProgramScheduleByDate(LocalDate date) {
		List<ProgramScheduled> programSchedule=programScheduleRepository.findByStartDate(date);
		return programSchedule;
	}
	
	@Override
	public int deleteProgramScheduleById(int scheduleId) {
		Optional<ProgramScheduled> programScheduled = programScheduleRepository.findById(scheduleId);
		ProgramScheduled pr = null;
		if(programScheduled.isPresent()) {
			pr = programScheduled.get();
			programScheduleRepository.delete(pr);
			return programScheduled.get().getScheduleId();
		}
		return 0;
	}

	@Override
	public ProgramScheduled getProgramScheduleById(int scheduleId) {
		Optional<ProgramScheduled> programScheduled = programScheduleRepository.findById(scheduleId);
		if(programScheduled.isPresent()) {
		return programScheduled.get();
    }
		return null;
	}

	@Override
	public int updateProgramSchedule(ProgramScheduled programSchedule) {
		Optional<ProgramScheduled> programScheduledFind = programScheduleRepository.findById(programSchedule.getScheduleId());
		ProgramScheduled prscheduled=null;
		if(programScheduledFind.isPresent()) {
			prscheduled=programScheduledFind.get();
			if(programSchedule.getScheduleId()!=0) {
				prscheduled.setScheduleId(programSchedule.getScheduleId());
			}
			if(programSchedule.getBranch()!=null) {
				prscheduled.setBranch(programSchedule.getBranch());
			}
			if(programSchedule.getCourse()!=null) {
				prscheduled.setCourse(programSchedule.getCourse());
			}
			if(programSchedule.getProgram()!=null) {
				prscheduled.setProgram(programSchedule.getProgram());
			}
			if(programSchedule.getStartDate()!=null) {
				prscheduled.setStartDate(programSchedule.getStartDate());
			}
			if(programSchedule.getEndDate()!=null) {
				prscheduled.setEndDate(programSchedule.getEndDate());
			}
		}
		return 0;
	}

}

