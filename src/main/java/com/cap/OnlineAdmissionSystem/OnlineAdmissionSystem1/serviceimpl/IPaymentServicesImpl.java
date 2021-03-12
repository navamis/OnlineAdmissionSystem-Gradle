package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Payment;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.DeletionException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.NotFoundException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.PaymentAddException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.ApplicationRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.repo.IPaymentRepository;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services.IPaymentServices;


@Service
public class IPaymentServicesImpl implements IPaymentServices{
//	static final Logger log = 
//	        LoggerFactory.getLogger(IPaymentServicesImpl.class);
	
	@Autowired
	IPaymentRepository paymentRepository;
	
	@Autowired
	ApplicationRepository applicationRepo;
	
	@Transactional
	@Override
	public Payment addPayment(Payment p) {
			Payment payment = paymentRepository.findPaymentDetailsByPaymentId(p.getId());
			if(payment == null) {
				paymentRepository.save(p);
				System.out.println(payment);
			}else {
					throw new PaymentAddException("Error in adding payment");
		}
		
		return payment;
	}

	@Override
	public List<Payment> viewAllPaymentDetails() {
		 List<Payment> payments = paymentRepository.findAll();
		 if(payments.isEmpty()) {
			 throw new NotFoundException("Details not found");
		 }
		 System.out.println(payments);
		 return payments;
		
	}

	@Override
	public ArrayList<Payment> getPaymentDetailsByEmail(String emailId) {
		ArrayList<Payment> payments = paymentRepository.findPaymentDetailsByEmailId(emailId);
		if(payments.isEmpty()) {
			 throw new NotFoundException("Details not found");
		 }
		System.out.println(payments);
		return payments;
	}

	@Override
	public Payment getPaymentDetailsByPaymentId(int paymentId) {
		Optional<Payment> payment = paymentRepository.findById(paymentId);
		if(payment.isEmpty()) {
			 throw new NotFoundException("Details not found");
		 }
		System.out.println(payment);
		return payment.get();
	}

	@Override
	public List<Payment> getPaymentDetailsByApplicationId(int applicationId) {
		List<Payment> payments = paymentRepository.findPaymentDetailsByApplicationId(applicationId);
		if(payments.isEmpty()) {
			 throw new NotFoundException("Details not found");
		 }
		System.out.println(payments);
		return payments;
	}

	@Override
	public ArrayList<Payment> getPayementDetailsByStatus(String paymentStatus) {
		ArrayList<Payment> payments = paymentRepository.findPayementDetailsByPaymentStatus(paymentStatus);
		if(payments.isEmpty()) {
			 throw new NotFoundException("Details not found");
		 }
		System.out.println(payments);
		return payments;
	}

	@Override
	public Payment deletePaymentById(int paymentId) {
	Optional<Payment> payment = paymentRepository.findById(paymentId);
	if(payment.isEmpty()) {
		throw new DeletionException("Error in deleting not existing object");
	}
	Payment p = payment.get();
	paymentRepository.delete(p);
		return p;
	}
	
	@Override
	@Transactional
	public Payment updatePaymentDetails(Payment p) {
			Optional<Payment> payment= paymentRepository.findById(p.getPaymentId());
			Payment p1=null;
			if(payment.isPresent()) {
				p1=payment.get();
				p1.setPaymentAmount(p.getPaymentAmount());
				p1.setPaymentDescription(p.getPaymentDescription());
				p1.setPaymentStatus(p.getPaymentStatus());
				return paymentRepository.save(p1);
			}
			return null;
			

	}
}
