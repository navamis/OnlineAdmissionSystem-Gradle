package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services;



import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Address;

public interface IAddressService {
	
	public Address addAddress(Address address);
	
	public void deleteAddressById(int addressId);
	
	public Address updateAddress(Address add);
	
	public Address getAddressById(int addressId);



	
	
	

}













