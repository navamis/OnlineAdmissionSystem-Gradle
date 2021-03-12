package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.test;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Application;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Payment;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.ProgramScheduled;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.serviceimpl.IPaymentServicesImpl;

@SpringBootTest
class IPaymentServicesTest {

	
	@Autowired
	IPaymentServicesImpl iPaymentServicesImpl;
	
	//@Test
//	public void testAddPayments() {
//		LocalDate time = LocalDate.now();
//		ProgramScheduled programScheduled=new ProgramScheduled(branch,course,program,collegeName,university, LocalDate.of(2021,03,01),LocalDate.of(2021,06,02));
//		Application application = new Application("abc",  LocalDate.of(2021,03,01),"agd" , 7.0, "ajshd", "jjhsaj", programScheduled, "asb",LocalDate.of(2021,03,01), "sajhg");
//	//	Application application1 = new Application("Zayn@gmail.com");
//		Payment payment = new Payment("Ajay@gmail.com",0.0,"Not Paid",time,"Payment Failed",application);
//		Payment payment1 = new Payment("Zayn@gmail.com",55200.0,"Paid",time,"Payment Approved",application1);
//		iPaymentServicesImpl.addPayment(payment);
//		iPaymentServicesImpl.addPayment(payment1);
////		Application application2 = new Application("Zayn@gmail.com");
////		Payment payment2 = new Payment("Zayn@gmail.com",55200.0,"Paid",time,"Payment Approved",application2);
////		iPaymentServicesImpl.addPayment(payment2);
//	}
	
	
	
//@Test
	public void testViewAllPaymentDetails() {
		iPaymentServicesImpl.viewAllPaymentDetails();
	}
	
	//@Test
	public void testGetPaymentDetailsByEmail() {
		iPaymentServicesImpl.getPaymentDetailsByEmail("Ajay@gmail.coom");
	}
	
//	@Test
	public void testGetPaymentDetailsByPaymentId() {
		iPaymentServicesImpl.getPaymentDetailsByPaymentId(1);
	}
	
	//@Test
	public void testGetPaymentDetailsByApplicationId() {
		iPaymentServicesImpl.getPaymentDetailsByApplicationId(2);
	}
	
	//@Test
	public void testGetPayementDetailsByStatus() {
		iPaymentServicesImpl.getPayementDetailsByStatus("Payment Approved");
	}
	
	//@Test
	public void testDeletePaymentById() {
		iPaymentServicesImpl.deletePaymentById(3);
	}
	
	
	//@Test
	public void testUpdatePaymentDetails() {
		Payment payment = iPaymentServicesImpl.getPaymentDetailsByPaymentId(3);
		payment.setPaymentAmount(60000);
		payment.setPaymentDescription("paid");
		payment.setPaymentStatus("Approved");
		iPaymentServicesImpl.updatePaymentDetails(payment);
	}
	
}
