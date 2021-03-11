package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Branch;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.AlreadyExistsException;


@Component
public interface IBranchService {
	
	public Branch addBranch(Branch branch) throws AlreadyExistsException;
	
	public ArrayList<Branch> viewAllBranchDetails();
	
	public Branch getBranchDetailsByName(String branchName);
	
	public int deleteBranchById(int branchId);
	
	public Branch getBranchById(int branchId);
	
	public int deleteBranchByName(String branchName);
	
	public int updateBranch(Branch branch);


}