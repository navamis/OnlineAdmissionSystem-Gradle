package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Address;



@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {

	Optional<Address> findByAddressId(int addressId);


	
	

}
