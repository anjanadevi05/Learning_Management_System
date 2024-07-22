package com.ds.boot_demo.util;

import java.util.List;
import java.util.stream.Collectors;

import com.ds.boot_demo.dto.AddressListDto;
import com.ds.boot_demo.dto.BankDetailsDto;
import com.ds.boot_demo.dto.ContactListDto;
import com.ds.boot_demo.dto.EducationalDetailListDto;
import com.ds.boot_demo.dto.EmployeePrimaryInfoDto;
import com.ds.boot_demo.dto.EmployeeSecondaryInfoDto;
import com.ds.boot_demo.dto.ExperienceListDto;
import com.ds.boot_demo.dto.TechSkillListDto;
import com.ds.boot_demo.entity.BankDetails;
import com.ds.boot_demo.entity.ContactDetails;
import com.ds.boot_demo.entity.EducationalDetails;
import com.ds.boot_demo.entity.EmployeeAddress;
import com.ds.boot_demo.entity.EmployeePrimaryDetails;
import com.ds.boot_demo.entity.EmployeeSecondaryDetails;
import com.ds.boot_demo.entity.ExperienceDetails;
import com.ds.boot_demo.entity.TechSkillDetails;

public class EmployeeUtil {
	private EmployeeUtil()
	{
		
	}
	//to make the .build() a reuseable code
	public static EmployeePrimaryDetails dtoToEntity(EmployeePrimaryInfoDto dto)
	{
		return EmployeePrimaryDetails.builder()
		.employeeId(dto.getEmployeeId())
		.emp_name(dto.getEmp_name())
		.dob(dto.getDob()) 
		.doj(dto.getDoj()) 
		.email(dto.getEmail()) 
		.BloodGroup(dto.getBloodGroup()) 
		.designation(dto.getDesignation()) 
		.gender(dto.getGender()) 
		.nationality(dto.getNationality()) 
		.employeeStatus(dto.getEmployeeStatus()) 
		.build();
	}
	
	public static EmployeeSecondaryDetails dtoToEntity(EmployeeSecondaryInfoDto dto)
	{
		return EmployeeSecondaryDetails.builder()
				.panNo(dto.getPanNo()).aadharNo(dto.getAadharNo()).fatherName(dto.getFatherName())
				.motherName(dto.getMotherName()).spouseName(dto.getSpouseName())
				.passportNo(dto.getPassportNo()).maritalStatus(dto.getMaritalStatus()).build();
		
	}
	
	
	public static List<EducationalDetails> dtoToEntities(EducationalDetailListDto dto)
	{
		return dto.getEducationalDetails().stream().map(edu->EducationalDetails.builder()
				.educationType(edu.getEducationType()).yop(edu.getYop())
				.percent(edu.getPercent()).University(edu.getUniversity())
				.institute(edu.getInstitute()).specialization(edu.getSpecialization())
				.state(edu.getState()).build()).collect(Collectors.toList());
	}
	
	public static List<EmployeeAddress> dtoToEntities(AddressListDto dto)
	{
		return dto.getAddresses().stream().map(loc->EmployeeAddress.builder()
				.addressType(loc.getAddressType()).doorNo(loc.getDoorNo())
				.Street(loc.getStreet()).locality(loc.getLocality())
				.city(loc.getCity()).landMark(loc.getLandMark())
				.pinCode(loc.getPinCode()).state(loc.getState())
				.build()).collect(Collectors.toList());
		
	}
	
	
	public static BankDetails dtoToEntity(BankDetailsDto dto)
	{
		return BankDetails.builder()
				.accNo(dto.getAccNo()).bankName(dto.getBankName()).accType(dto.getAccType())
				.ifscCode(dto.getIfscCode()).branch(dto.getBranch())
				.state(dto.getState()).build();
		
	}
	
	public static List<TechSkillDetails> dtoToEntities(TechSkillListDto dto)
	{
		return dto.getTechskill().stream().map(skill->TechSkillDetails.builder()
				.skillType(skill.getSkillType()).rating(skill.getRating())
				.yoe(skill.getYoe()).build()).collect(Collectors.toList());
	}
	public static List<ExperienceDetails> dtoToEntities(ExperienceListDto dto) {
		// TODO Auto-generated method stub
		return dto.getExperience().stream().map(job->ExperienceDetails.builder()
				.companyType(job.getCompanyType()).yearsOfExperience(job.getYearsOfExperience())
				.dateOfJoining(job.getDateOfJoining()).dateOfRelieving(job.getDateOfRelieving())
				.designation(job.getDesignation()).location(job.getLocation())
				.build()).collect(Collectors.toList());
	}
	public static List<ContactDetails> dtoToEntities(ContactListDto dto) {
		// TODO Auto-generated method stub
		return dto.getContact().stream().map(ph->ContactDetails.builder()
				.contactType(ph.getContactType()).ContactNumber(ph.getContactNumber())
				.build()).collect(Collectors.toList());
	}


}
