package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services;

import java.util.ArrayList;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Application;


public interface ApplicationService {
public ArrayList<Application> viewAllApplicationDetails();
public ArrayList<Application> getApplicationDetailsByEmail(String email);
public Application addApplication(Application application);
public ArrayList<Application> getApplicationDetailsByStatus(String status);
public int deleteApplicationById(int applicationId);
public int deleteApplicationByEmail(String email);
public Application getApplicationById(int applicationId);
public int updateApplicationStatus(Application app);
}
