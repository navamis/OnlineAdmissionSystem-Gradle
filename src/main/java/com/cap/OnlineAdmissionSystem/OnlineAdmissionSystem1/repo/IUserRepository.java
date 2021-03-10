package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>   {

	User findByUserId(int userId);
//
//	User getUserDetailsById(int userId);
//
//	User  updateUserDetails(User user);
//
//	User deleteUserDetailsById(int userId);
//	
//	public ArrayList<User> getAllUserDetails();

//	public Login save(Login login);
//	
//	public List<User> findAll();
//	public List<Login> findAllLogin();
//
//	public  ArrayList<User> findById(String userId);
//
//	Login deleteUserDetailsById(Integer userId);
//
//	public User addUserDetails(User user);
//	
//	public ArrayList<User> getAllUserDetails();
//	
//  public User getUserDetailsById(String userId);
//
//	public User deleteUserDetailsById(String userId);
//	
//	public User updateUserDetails(User user);
//
//	public Login addLoginDetails(Login login);
//	
//  public ArrayList<Login> getAllLoginDetails();
//
//	public Login getLoginDetailsById(String userId);
//	
//	public Login deleteLoginDetailsById(String Id);
//	
//	public  Login changePassword(Login login);
//	
//	public Login resetPassword(Login login);
	
	

	
	
	
	
	
}

