package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.ProgramScheduled;


@Repository
public interface IProgramScheduleRepository extends JpaRepository<ProgramScheduled, Integer> {


	List<ProgramScheduled> findByStartDate(LocalDate date);
	

}
