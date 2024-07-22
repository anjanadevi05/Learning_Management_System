package com.ds.boot_demo.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name="employee_primary_info")
public class EmployeePrimaryDetails {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "employee_id", unique = true)
	private String employeeId;
	
	@Column(name = "employee_name")
	private String  emp_name;
	
	@Column(name = "date_of_joining")
	private LocalDate  doj;
	
	@Column(name = "date_of_birth")
	private LocalDate dob;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "blood_group")
	private String BloodGroup;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "employee_status")
	private String employeeStatus;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="primaryinfo")
	private EmployeeSecondaryDetails secondaryinfo;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="primaryinfo")
	private List<EducationalDetails> educationalDetails;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="primaryinfo")
	private List<EmployeeAddress> addresses;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="primaryinfo")
	private BankDetails bankAccinfo;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="primaryinfo")
	private List<TechSkillDetails> techSkill;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="primaryinfo")
	private List<ExperienceDetails> experience;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="primaryinfo")
	private List<ContactDetails> contact;
	
	

}
