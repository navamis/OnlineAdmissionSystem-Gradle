package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Program;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.AlreadyExistsException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.ProgramNotFoundException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.IProgramRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services.IProgramService;

@Service
public class ProgramServiceImplementation implements IProgramService{
//	static final Logger log = 
//	        LoggerFactory.getLogger(ProgramServiceImplementation.class);
	@Autowired
	IProgramRepository programRepository;

	@Override
	public Program addProgram(Program program) throws AlreadyExistsException {
		Optional<Program> pr=programRepository.findById(program.getProgramId());
		if(pr.isPresent()) {
			throw new AlreadyExistsException("Program " +program.getProgramName()+" already exists");		

		}else {
			programRepository.save(program);
		return program; 
		}
	}

	@Override
	public ArrayList<Program> viewAllProgramDetails() throws ProgramNotFoundException {
		ArrayList<Program> programs = new ArrayList<Program>(programRepository.findAll());
		if(programs.isEmpty()) {
			throw new ProgramNotFoundException("Program Not Found");
		}
		return programs;
	}

	@Override
	public ArrayList<Program> getApplicationDetailsByCollegeName(String collegeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Program getProgramDetailsByName(String programName) {
		Program program =programRepository.findByProgramName(programName);
		return program;
	}

	@Override
	public ArrayList<Program> getProgramDetailsByEligibility(String eligibility) {
		ArrayList<Program> program =new ArrayList<Program>(programRepository.findByEligibility(eligibility));
		return program;
	}

	@Override
	public int deleteProgramById(int programId) {
		Optional<Program> program = programRepository.findById(programId);
		Program pr = null;
		if(program.isPresent()) {
			pr = program.get();
			programRepository.delete(pr);
			return program.get().getProgramId();
		}
		return 0;
	}

	@Override
	public int deleteProgramByName(String programName) {
		Program program = programRepository.findByProgramName(programName);
		if (!(program==null))
		{
				programRepository.delete(program);
				return program.getProgramId();
		}
		return 0;
	}

	@Override
	public Program getProgramById(int programId) {
		Optional<Program> program = programRepository.findById(programId);
		if(program.isPresent()) {
			return program.get();
//		return program.get().getProgramId();
    }
		return null;
	}

	@Override
	public int updateProgramStatus(Program program) {
		Optional<Program> programFind = programRepository.findById(program.getProgramId());
		Program pr=null;
		if(programFind.isPresent()) {
			pr=programFind.get();
			if(program.getProgramId()!=0) {
				pr.setProgramId(program.getProgramId());
			}
			if(program.getProgramName()!=null) {
				pr.setProgramName(program.getProgramName());
			}
			if(program.getDegreeOffered()!=null) {
				pr.setDegreeOffered(program.getDegreeOffered());
			}
			if(program.getDuration()!=null) {
				pr.setDuration(program.getDuration());
			}
			if(program.getEligibility()!=null) {
				pr.setEligibility(program.getEligibility());
			}
		}
		return 0;
	}

}