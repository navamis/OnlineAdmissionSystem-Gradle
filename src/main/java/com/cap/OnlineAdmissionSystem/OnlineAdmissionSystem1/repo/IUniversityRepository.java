package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.University;

@Repository
public interface IUniversityRepository extends JpaRepository<University, Integer>{

	ArrayList<University> findByAddressCity(String city);

	ArrayList<University> findByCollegeCollegeName(String collegeName);

	
}
