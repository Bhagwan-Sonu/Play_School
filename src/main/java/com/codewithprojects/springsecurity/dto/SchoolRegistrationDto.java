package com.codewithprojects.springsecurity.dto;


public class SchoolRegistrationDto {

	
	private String school_name;
	
	private String owner_Chairperson_Name;
		
	private String address;
	
	private String district;
	
	private String mobile_No;

	public SchoolRegistrationDto() {
		super();
	}

	public SchoolRegistrationDto(String school_name, String owner_Chairperson_Name, String address, String district,
			String mobile_No) {
		super();
		this.school_name = school_name;
		this.owner_Chairperson_Name = owner_Chairperson_Name;
		this.address = address;
		this.district = district;
		this.mobile_No = mobile_No;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public String getOwner_Chairperson_Name() {
		return owner_Chairperson_Name;
	}

	public void setOwner_Chairperson_Name(String owner_Chairperson_Name) {
		this.owner_Chairperson_Name = owner_Chairperson_Name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getMobile_No() {
		return mobile_No;
	}

	public void setMobile_No(String mobile_No) {
		this.mobile_No = mobile_No;
	}

}
