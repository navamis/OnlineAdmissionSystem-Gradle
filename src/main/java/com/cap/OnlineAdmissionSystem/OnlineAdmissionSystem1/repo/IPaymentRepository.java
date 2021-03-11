package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Payment;


@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer>{


	public  ArrayList<Payment> findPaymentDetailsByEmailId(String emailId);	
	
	public  Payment findPaymentDetailsByPaymentId(int paymentId);	
	
	
	@Query("select p from  Payment p inner join p.application a  where a.applicationId = ?1")
	public  List<Payment> findPaymentDetailsByApplicationId(int applicationId);

	public ArrayList<Payment> findPayementDetailsByPaymentStatus(String paymentStatus);


}
