package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Transaction Detail of payment")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "paymentId")

public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "payment_sequence")
	@SequenceGenerator(name = "payment_sequence",allocationSize = 1)
	@ApiModelProperty(notes = "Payment Id for Payment reference")
	private int paymentId;
	

	@ApiModelProperty(notes = "Email ID of User")
	private String emailId;
	
	
	@ApiModelProperty(notes = "Amount paid")
	private double paymentAmount;
	
	@ApiModelProperty(notes = "Descrition of payment")
	private String paymentDescription;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@ApiModelProperty(notes = "Payment Date")
	private LocalDate paymentDate;
	
	@ApiModelProperty(notes = "Status of payment")
	private String paymentStatus;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "applicationId")
	@ApiModelProperty(notes = "User Application")
	Application application;

	

	public int getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(int paymentId) {
		System.out.println(paymentId);
		this.paymentId = paymentId;
	}

	
	public double getPaymentAmount() {
		return paymentAmount;
	}



	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}



	public String getPaymentDescription() {
		return paymentDescription;
	}



	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}



	public LocalDate getPaymentDate() {
		return paymentDate;
	}



	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}



	public Application getApplication() {
		return application;
	}



	public void setApplication(Application application) {
		this.application = application;
	}

	
	public Payment() {}
	
	
	
	public Payment(String emailId, double paymentAmount, String paymentDescription, LocalDate paymentDate,
			String paymentStatus,Application application) {
		super();
		this.emailId = emailId;
		this.paymentAmount = paymentAmount;
		this.paymentDescription = paymentDescription;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
		this.application = application;
	}



	public int getId() {
		return paymentId;
	}



	public void setId(int paymentId) {
		this.paymentId = paymentId;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getPaymentStatus() {
		return paymentStatus;
	}



	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}



	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", emailId=" + emailId + ", paymentAmount=" + paymentAmount
				+ ", paymentDescription=" + paymentDescription + ", paymentDate=" + paymentDate + ", paymentStatus="
				+ paymentStatus + ", application=" + application + "]";
	}
	
	
	
	
	

}
