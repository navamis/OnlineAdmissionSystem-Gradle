package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class College {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int collegeRegId;
		
		
		    private String collegeName;
		 
		 
		 @OneToOne(cascade=CascadeType.ALL)
		    private Address address;
		 
		
		 @OneToMany(cascade=CascadeType.ALL)
		    private List<Program> program;

		
		 @OneToMany(cascade=CascadeType.ALL)
		    private List<Course> course;
		 
		 	 
		 @OneToMany(cascade=CascadeType.ALL)
		    private List<Branch> branch;
		 
		  
//    	 @ManyToOne
//		 @JoinColumn(name = "name")
//			private University university;
		 
		 public College() {
			 
		 }


		public College(String collegeName, Address address, ArrayList<Program> program, ArrayList<Course> course, ArrayList<Branch> branch){
			super();
			this.collegeName = collegeName;
			this.address = address;
			this.program = program;
			this.course = course;
			this.branch = branch;
			//this.university = university;
		}




		public int getCollegeRegId() {
			return collegeRegId;
		}

		public void setCollegeRegId(int collegeRegId) {
			this.collegeRegId = collegeRegId;
		}

		public String getCollegeName() {
			return collegeName;
		}

		public void setCollegeName(String collegeName) {
			this.collegeName = collegeName;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public List<Program> getProgram() {
			return program;
		}

		public void setProgram(ArrayList<Program> program) {
			this.program = program;
		}

		public List<Course> getCourse() {
			return course;
		}

		public void setCourse(ArrayList<Course> course) {
			this.course = course;
		}

		public List<Branch> getBranch() {
			return branch;
		}

		public void setBranch(ArrayList<Branch> branch) {
			this.branch = branch;
		}


		@Override
		public String toString() {
			return "College [collegeRegId=" + collegeRegId + ", collegeName=" + collegeName + ", address=" + address
					+ ", program=" + program + ", course=" + course + ", branch=" + branch + "]";
		}


		
}

		