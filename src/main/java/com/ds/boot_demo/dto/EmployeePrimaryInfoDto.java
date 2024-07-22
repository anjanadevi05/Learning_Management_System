package com.ds.boot_demo.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeePrimaryInfoDto {

	//private Integer id;--no need when pathvarable is used
	private String employeeId;
	private String emp_name;
	private LocalDate doj;
	private LocalDate dob;
	private String email;
	private String BloodGroup; 
	private String designation;
	private String gender;
	private String nationality;
	private String employeeStatus;
	
	
	
	//we use the primary info details in such a way that we get all the data back
	private EmployeeSecondaryInfoDto secondaryInfo;
	private List<EducationalDetailDto> education;
	private List<AddressDto> addresses;
	private BankDetailsDto bank;
	private List<TechSkillDto> skills;
	private List<ExperienceDto> experience;
	private List<ContactDto> contact;
	
	
	
}
