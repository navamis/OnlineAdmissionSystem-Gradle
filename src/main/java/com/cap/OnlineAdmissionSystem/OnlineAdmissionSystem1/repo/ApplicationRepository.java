package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer>{
public ArrayList<Application> findByEmailId(String emailId);
public ArrayList<Application> findByApplicationStatus(String applicationStatus);
}
