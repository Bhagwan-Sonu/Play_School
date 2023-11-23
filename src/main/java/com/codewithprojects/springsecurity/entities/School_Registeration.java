package com.codewithprojects.springsecurity.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "registration")
public class School_Registeration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="School_Name", nullable=false)
	private String school_name;
	
	@Column(name="Principal_Name", nullable=false)
	private String owner_Chairperson_Name;
	
	@Column(name="Address", nullable=false)
	private String address;
	
	@Column(name="District", nullable=false)
	private String district;
	
	@Column(name="Mobile_Number", nullable=false)
	private String mobile_No;

	public School_Registeration() {
		super();
	}

	public School_Registeration(String school_name, String owner_Chairperson_Name, String address, String district,
			String mobile_No) {
		super();
		this.school_name = school_name;
		this.owner_Chairperson_Name = owner_Chairperson_Name;
		this.address = address;
		this.district = district;
		this.mobile_No = mobile_No;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
