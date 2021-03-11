package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo;

//import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Branch;


@Repository
public interface IBranchRepository extends JpaRepository<Branch,Integer>{
	
    public Branch findByBranchName(String branchName);
    
//    public Branch findByBranchname(String branchName);

	public Branch findByBranchId(int branchId);

}