package com.cap.OnlineAdmissionSystem.OnlineAdmissionSystem1.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;
    private String district;
    private String state;
    private String city;
    private String country;
	private long zipcode;
    private String landmark;
	
    
    public Address( String district, String state, String city, String country, long zipcode,
			String landmark) {
		super();
		
		this.district = district;
		this.state = state;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		this.landmark = landmark;}
	

    public Address() {
    
    }

	public int getAddressId() {
		return addressId;
	}



	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}



	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public long getZipcode() {
		return zipcode;
	}


	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}


	public String getLandmark() {
		return landmark;
	}


	


	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", district=" + district + ", state=" + state + ", city=" + city
				+ ", country=" + country + ", zipcode=" + zipcode + ", landmark=" + landmark + "]";
	}
    
}