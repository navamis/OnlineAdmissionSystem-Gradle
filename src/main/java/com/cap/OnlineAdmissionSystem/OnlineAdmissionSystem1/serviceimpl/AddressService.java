package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Address;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.AddressAlreadyExistsException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.AddressNotFoundException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.IAddressRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services.IAddressService;


@Service
public class AddressService implements IAddressService{
	
	@Autowired
	IAddressRepository addrepo;

	@Override
	public Address addAddress(Address address) {
		Optional<Address> add=addrepo.findByAddressId(address.getAddressId());
		if(add.isPresent()) {
			throw new AddressAlreadyExistsException("Address Already Exists");
		}
		else {
		addrepo.save(address);
		return address;
	}
	}
	
	
	@Override
	public void deleteAddressById(int addressId) 
	{
		 Optional<Address> add = addrepo.findByAddressId(addressId);
         
	        if(add.isPresent()) 
	        {
	            addrepo.deleteById(addressId);
	        } else {
	            throw new AddressNotFoundException("No employee record exist for given id");
	        }
	        
	    } 
		
	

	@Override
	@Transactional
	public Address updateAddress(Address add) {
		  {
			  Address add1=null;
		        Optional<Address> address = addrepo.findByAddressId(add.getAddressId());
		        {
		        if(address.isPresent())
		        {
		        	
		        add1=address.get();
		       add1.setCity(add.getCity());
		       add1.setState(add.getState());
		       add1.setZipcode(add.getZipcode());
		        //addrepo.save(add1);
		         
		        } 
		return add1;
		        }
		       
		  }
		  }

	@Override
	public Address getAddressById(int addressId) {
		Optional<Address> add2 = addrepo.findByAddressId(addressId);
		if(add2.isEmpty())
		{
			throw new AddressNotFoundException("No Address record exist for given id");
	
	}
		return add2.get();
		//System.out.println(add2);
	}
}