package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class University 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Universityid;
	String name;
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name="addressId")
	Address address;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	List<College> college;
	
	
	public University() {}
	


	public University(String name, Address address, ArrayList<College> college) {
		super();
		//Universityid = universityid;
		this.name = name;
		this.address = address;
		this.college = college;
	}



	public int getUniversityid() {
		return Universityid;
	}



	public void setUniversityid(int universityid) {
		Universityid = universityid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public List<College> getCollege() {
		return college;
	}



	public void setCollege(List<College> list) {
		this.college = list;
	}



	@Override
	public String toString() {
		return "University [Universityid=" + Universityid + ", name=" + name + ", address=" + address + ", collegelist="
				+ college + "]";
	}
		

}
