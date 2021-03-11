package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities.Payment;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.DeletionException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.exceptions.PaymentAddException;
import com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.services.IPaymentServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/Api")
@Api(value = "Payment", tags = {"PaymentAPI"})
public class OnlineAdmissionSystemController {

	
	@Autowired
	IPaymentServices paymentServices;
	
	/**
	 * This method is for Adding a payment
	 * 
	 * 
	 * @param Payment
	 * @return payment
	 * @throws PaymentAddException
	 */
	
	@PostMapping("/payments")
	@ApiOperation(value="Add a Payment", notes= "Provide payment details" , response = Payment.class)
	public ResponseEntity<Payment> addPayment(
	@ApiParam(value = "Payment to be added",required = true)@RequestBody Payment payment){
	Payment payments = paymentServices.addPayment(payment);
		return new ResponseEntity<>(payments,HttpStatus.CREATED);	
	}
	
	/**
	 * This method is for getting list of all payments
	 * 
	 * 
	 * @return List<Payment>
	 * @throws NotFoundException
	 */
	
	@GetMapping("/payments")
	@ApiOperation(value = "View all payments",response= Payment.class)
	public ResponseEntity<List<Payment>> viewAllPaymentDetails(){
	List<Payment> payments = paymentServices.viewAllPaymentDetails();
		return new ResponseEntity<>(payments,HttpStatus.OK);
	}
	
	/**
	 * This method is for getting list of payments by emailId
	 * 
	 * 
	 * @return List<Payment>
	 * @throws NotFoundException
	 */
	
	@GetMapping("/paymentsByEmailId/{emailId}")
	@ApiOperation(value = "View payment by emailId",response= Payment.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Payment>> getPaymentDetailsByEmail(@PathVariable("emailId") String emailId){
		List<Payment> payments = paymentServices.getPaymentDetailsByEmail(emailId);
		return new ResponseEntity<>(payments,HttpStatus.OK);
	}
	
	
	/**
	 * This method is for getting list of payments by paymentId
	 * 
	 * 
	 * @return Payment
	 * @throws NotFoundException
	 */
	
	@GetMapping("/paymentsByPaymentId/{paymentId}")
	@ApiOperation(value = "View payment by paymentId",notes = "Provide paymentId",response= Payment.class)
	public ResponseEntity<Payment> getPaymentDetailsByPaymentId(
	@ApiParam(value="payment id to view payment") @PathVariable("paymentId") int paymentId){
		Payment payments = paymentServices.getPaymentDetailsByPaymentId(paymentId);
		return new ResponseEntity<>(payments,HttpStatus.OK);
	}
	
	/**
	 * This method is for getting list of payments by ApplicationId
	 * 
	 * 
	 * @return List<Payment>
	 * @throws NotFoundException
	 */
	
	@GetMapping("/paymentsByApplicationId/{applicationId}")
	@ApiOperation(value = "View payment by applicationId",notes = "Provide applicationId",response= Payment.class)
	public ResponseEntity<List<Payment>> getPaymentDetailsByApplicationId(
	@ApiParam(value="Applicatio ID to view payment") @PathVariable("applicationId") int applicationId){
		List<Payment> payments = paymentServices.getPaymentDetailsByApplicationId(applicationId);
		return new ResponseEntity<>(payments,HttpStatus.OK);
	}
	
	/**
	 * This method is for getting list of payments by paymentStatus
	 * 
	 * 
	 * @return List<Payment>
	 * @throws NotFoundException
	 */
	
	
	@GetMapping("/paymentsByStatus/{paymentStatus}")
	@ApiOperation(value = "View payment by paymentStatus",notes = "Provide paymentStatus",response= Payment.class)
	public ResponseEntity<List<Payment>> getPayementDetailsByStatus(
	@ApiParam(value="Payment status to view payment") @PathVariable("paymentStatus") String paymentStatus){
		List<Payment> payments = paymentServices.getPayementDetailsByStatus(paymentStatus);
		return  new ResponseEntity<>(payments,HttpStatus.OK);
	}
	
	/**
	 * This method is for deleting list of payments by paymentId
	 * 
	 * 
	 * @return String
	 * @throws DeletionException
	 */
	
	@DeleteMapping("/payment/{paymentId}")
	@ApiOperation(value = "Delete payment by paymentId",notes = "Provide paymentId",response= Payment.class)
	public ResponseEntity<String> deletePayment(
	@ApiParam(value="Id of the payment to be deleted",required = true) @PathVariable("paymentId") int paymentId) {
		paymentServices.deletePaymentById(paymentId);
		return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
	}
	
	/**
	 * This method is for Updating payments by paymentId
	 * 
	 * 
	 * @return String
	 * @throws NotFoundException
	 */
	
	@PutMapping("/payments")
	@ApiOperation(value = "Update Booking",notes = "Provide paymentId",response= Payment.class)
	public ResponseEntity<String> updatePaymentDetails(
	@ApiParam(value="Id of the payment to be uploaded",required = true) @RequestBody Payment payment) {
		System.out.println("Controller" + payment);
		paymentServices.updatePaymentDetails(payment);
		return new ResponseEntity<>("Successfully updated",HttpStatus.OK);
	}
	
	
	
}
