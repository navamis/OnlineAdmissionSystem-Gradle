package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services;


import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Login;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.User;

@Service
public interface IUserService {
	

    public User addUserDetails(User user);
    
    public Login addLoginDetails(Login login);
    
    public ArrayList<User> getAllUserDetails();
    
    public ArrayList<Login> getAllLoginDetails();
    
    public User getUserDetailsById(int userId);
    
    public Login getLoginDetailsById(int userId);
    
    public User deleteUserDetailsById(int userId);
      
    public Login deleteLoginDetailsById(int userId);
    
    public Login changePassword(Login login );
    
    public Login resetPassword(Login login );
    
    public User updateUserDetails(User user);

	
}
