package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int applicationId;
	String applicantFullName;
	LocalDate dateOfBirth;
	String highestQualification;
	double finalYearPercentage;
	String goals;
	String emailId;
	@OneToOne(cascade=CascadeType.ALL)
	ProgramScheduled schedule;
	String applicationStatus;
	LocalDate dateOfInterview;
	String applicantInterviewFeedback;
	
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Application(int applicationId, String applicantFullName, LocalDate dateOfBirth, String highestQualification,
			double finalYearPercentage, String goals, String emailId, ProgramScheduled schedule,
			String applicationStatus, LocalDate dateOfInterview, String applicantInterviewFeedback) {
		super();
		this.applicationId = applicationId;
		this.applicantFullName = applicantFullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.finalYearPercentage = finalYearPercentage;
		this.goals = goals;
		this.emailId = emailId;
		this.schedule = schedule;
		this.applicationStatus = applicationStatus;
		this.dateOfInterview = dateOfInterview;
		this.applicantInterviewFeedback = applicantInterviewFeedback;
	}

	public Application(String applicantFullName, LocalDate dateOfBirth, String highestQualification,
			double finalYearPercentage, String goals, String emailId, ProgramScheduled schedule,
			String applicationStatus, LocalDate dateOfInterview, String applicantInterviewFeedback) {
		super();
		this.applicantFullName = applicantFullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.finalYearPercentage = finalYearPercentage;
		this.goals = goals;
		this.emailId = emailId;
		this.schedule = schedule;
		this.applicationStatus = applicationStatus;
		this.dateOfInterview = dateOfInterview;
		this.applicantInterviewFeedback = applicantInterviewFeedback;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicantFullName() {
		return applicantFullName;
	}

	public void setApplicantFullName(String applicantFullName) {
		this.applicantFullName = applicantFullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public double getFinalYearPercentage() {
		return finalYearPercentage;
	}

	public void setFinalYearPercentage(double finalYearPercentage) {
		this.finalYearPercentage = finalYearPercentage;
	}

	public String getGoals() {
		return goals;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public ProgramScheduled getSchedule() {
		return schedule;
	}

	public void setSchedule(ProgramScheduled schedule) {
		this.schedule = schedule;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public LocalDate getDateOfInterview() {
		return dateOfInterview;
	}

	public void setDateOfInterview(LocalDate dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}

	public String getApplicantInterviewFeedback() {
		return applicantInterviewFeedback;
	}

	public void setApplicantInterviewFeedback(String applicantInterviewFeedback) {
		this.applicantInterviewFeedback = applicantInterviewFeedback;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", applicantFullName=" + applicantFullName
				+ ", dateOfBirth=" + dateOfBirth + ", highestQualification=" + highestQualification
				+ ", finalYearPercentage=" + finalYearPercentage + ", Goals=" + goals + ", emailId=" + emailId
				+ ", schedule=" + schedule + ", applicationStatus=" + applicationStatus + ", dateOfInterview="
				+ dateOfInterview + ", applicantInterviewFeedback=" + applicantInterviewFeedback + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goals == null) ? 0 : goals.hashCode());
		result = prime * result + ((applicantFullName == null) ? 0 : applicantFullName.hashCode());
		result = prime * result + ((applicantInterviewFeedback == null) ? 0 : applicantInterviewFeedback.hashCode());
		result = prime * result + applicationId;
		result = prime * result + ((applicationStatus == null) ? 0 : applicationStatus.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((dateOfInterview == null) ? 0 : dateOfInterview.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(finalYearPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((highestQualification == null) ? 0 : highestQualification.hashCode());
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Application other = (Application) obj;
		if (goals == null) {
			if (other.goals != null)
				return false;
		} else if (!goals.equals(other.goals))
			return false;
		if (applicantFullName == null) {
			if (other.applicantFullName != null)
				return false;
		} else if (!applicantFullName.equals(other.applicantFullName))
			return false;
		if (applicantInterviewFeedback == null) {
			if (other.applicantInterviewFeedback != null)
				return false;
		} else if (!applicantInterviewFeedback.equals(other.applicantInterviewFeedback))
			return false;
		if (applicationId != other.applicationId)
			return false;
		if (applicationStatus == null) {
			if (other.applicationStatus != null)
				return false;
		} else if (!applicationStatus.equals(other.applicationStatus))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (dateOfInterview == null) {
			if (other.dateOfInterview != null)
				return false;
		} else if (!dateOfInterview.equals(other.dateOfInterview))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (Double.doubleToLongBits(finalYearPercentage) != Double.doubleToLongBits(other.finalYearPercentage))
			return false;
		if (highestQualification == null) {
			if (other.highestQualification != null)
				return false;
		} else if (!highestQualification.equals(other.highestQualification))
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		return true;
	}
	


}
