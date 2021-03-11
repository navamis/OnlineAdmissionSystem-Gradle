package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



	import java.util.ArrayList;

	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;

	import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Login;
	import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.User;
	import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.ILoginRepository;
	import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.IUserRepository;
	import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services.IUserService;

	@SpringBootTest
	class UserTest {
		
		@Autowired
		IUserRepository userRepository;
		
		@Autowired
	    IUserService userService;
	    
		@Autowired
		ILoginRepository loginRepository;
		
	    //User user = new User(100, "Ria", "Ann", "Charles", "ria@gmail.com", "9999999999", "1234 5678 9876");
//	    User user1 = new User(101, "Ria", "Ann", "Charles", "ria@gmail.com", "9999999999", "1234 5678 9876");
//		User use2 = new User(112, "John", "Roy", "Thomas", "john@gmail.com", "1111111111", "9876 5432 1987");

		Login login = new Login(14, "123abc", "Student");
		Login login2 = new Login(10, "agr", "Admin");
//		Login login1 = new Login(102, "abc", "Student");

		
		//@Test
		public void addTest() {
			System.out.println("eholl");
		}
		
		//@Test
		public void testaddUserDetails() {		
			User user = new User(111, "Ria", "Ann", "Charles", "ria@gmail.com", "9999999999", "1234 5678 9876");
			User u = userService.addUserDetails(user);
			System.out.println(u);
		}
		

		//@Test
		public void testgetAllUserDetails() {
			
			ArrayList<User> u = userService.getAllUserDetails();
			System.out.println(u);
		}
		
			
		//@Test
		public void testgetUserDetailsById() {
			userService.getUserDetailsById(111);
		}
		
	    //@Test
		public void testdeleteUserDetailsById() {
			userService.deleteUserDetailsById(115);
		}
			
		//@Test
		public void testupdateUserDetails() {
//			userService.updateUserDetails(user);
			}
	//Login Test Cases----------------------------------------------------------------------------------------------------------		
			
		//@Test
		public void testaddLoginDetails() {
			Login login = new Login(101, "xyz", "Admin");
		    userService.addLoginDetails(login);
			}
		
		
		//@Test
		public void testgetAllLoginDetails() {
			userService.getAllLoginDetails();
		}
		

		//@Test
		public void testgetLoginDetailsById() {
	      userService.getLoginDetailsById(101);		
		}

		
		//@Test
		public void testdeleteLoginDetailsById() {
			userService.deleteLoginDetailsById(20);
			//System.out.println(l);
		}
		
		
		//@Test
		public void testchangePassword() {
			userService.changePassword(login);
		}
		
		
		//@Test
		public void testresetPassword() {
			userService.resetPassword(login);
		}
		
		
		
		
		}





