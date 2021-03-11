package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.test;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Address;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.IAddressRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services.IAddressService;




@SpringBootTest
public class AddressTest {

	@Autowired
	IAddressRepository addressrepository;
	
	@Autowired
	IAddressService addservice;
	
	Address address= new Address("Banglore Urban","Karnataka","Banglore","India",560032,"Dental college");
	Address address1= new Address("Banglore Rural","Karnataka","Banglore","India",540098,"Temple");
	
	@Test
	public void TestaddAddress()
	{
		addservice.addAddress(address1);	
	}
	

	//@Test
	public void TestdeleteAddress() {
		addservice.deleteAddressById(13);	
	}

	//@Test
	public void TestupdateAddress() {

	addservice.updateAddress(address1);
	
	}

	
	//@Test
	public void TestgetAddressById()
	{
		addservice.getAddressById(12);	
	}
}
