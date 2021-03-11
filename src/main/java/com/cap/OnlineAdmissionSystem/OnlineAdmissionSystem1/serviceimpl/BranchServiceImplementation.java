package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Branch;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.AlreadyExistsException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.BranchNotFoundException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.IBranchRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services.IBranchService;


@Service
public class BranchServiceImplementation implements IBranchService {
	
	@Autowired
	IBranchRepository branchRepository;

	@Override
	public Branch addBranch(Branch branch) throws AlreadyExistsException {
		Optional<Branch> br=branchRepository.findById(branch.getBranchId());
		if(br.isPresent()) {
			throw new AlreadyExistsException("Branch " +branch.getBranchName()+" already exists");		

		}else {
			branchRepository.save(branch);
		return branch; 
		}
	}
	
	@Override
	public ArrayList<Branch> viewAllBranchDetails(){
		ArrayList<Branch> branches = new ArrayList<Branch>(branchRepository.findAll());
		if(branches.isEmpty()) {
			throw new BranchNotFoundException("Branch not Found");
		}
		return branches;
	}
	
	@Override
	public Branch getBranchDetailsByName(String branchName){
		Branch branch =branchRepository.findByBranchName(branchName);
		return branch;
	}
	
	@Override
	public int deleteBranchById(int branchId) {
		Optional<Branch> branch = branchRepository.findById(branchId);
		Branch br = null;
		if(branch.isPresent()) {
			br = branch.get();
			branchRepository.delete(br);
			return branch.get().getBranchId();
		}
		return 0;
	}
	
	@Override
	public Branch getBranchById(int branchId) {
		Optional<Branch> branch = branchRepository.findById(branchId);
		if(branch.isEmpty()) {
			throw new BranchNotFoundException("Branch not found");
    }
		return branch.get();
	}
	
	@Override
	public int deleteBranchByName(String branchName) {
		Branch branch = branchRepository.findByBranchName(branchName);
		if (!(branch==null))
		{
				branchRepository.delete(branch);
				return branch.getBranchId();
		}else {
			throw new BranchNotFoundException("Branch not found");
		}
	}

	@Override
	@Transactional
	public int updateBranch(Branch branch) {
		Optional<Branch> branchFind = branchRepository.findById(branch.getBranchId());
		Branch br=null;
		if(branchFind.isPresent()) {
			br=branchFind.get();
			if(branch.getBranchName()!=null) {
				br.setBranchName(branch.getBranchName());
			}
			if(branch.getBranchId()!=0) {
				br.setBranchId(branch.getBranchId());
			}
			if(branch.getBranchDescription()!=null) {
				br.setBranchDescription(branch.getBranchDescription());
			}
		}
		return 0;
	}
	
}
	
	
	
