package com.ds.boot_demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="Experience")
public class ExperienceDetails {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "company_type")
	private String companyType;
	
	
	@Column(name = "years_of_exp")
	private String yearsOfExperience;
	
	@Column(name = "doj")
	private String dateOfJoining;
	
	@Column(name = "dor")
	private String dateOfRelieving;
	
	
	@Column(name = "designation")
	private String designation;
	
	
	@Column(name = "location")
	private String location;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private EmployeePrimaryDetails primaryinfo;
	

}
