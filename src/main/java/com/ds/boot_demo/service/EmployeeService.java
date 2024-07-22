package com.ds.boot_demo.service;

import com.ds.boot_demo.dto.AddressListDto;
import com.ds.boot_demo.dto.BankDetailsDto;
import com.ds.boot_demo.dto.ContactListDto;
import com.ds.boot_demo.dto.EducationalDetailListDto;
import com.ds.boot_demo.dto.EmployeePrimaryInfoDto;
import com.ds.boot_demo.dto.EmployeeSecondaryInfoDto;
import com.ds.boot_demo.dto.ExperienceListDto;
import com.ds.boot_demo.dto.TechSkillListDto;

public interface EmployeeService {

	Integer saveEmployeePrimaryInfo(EmployeePrimaryInfoDto dto);
	
	Integer saveEmployeeSecondaryInfo(EmployeeSecondaryInfoDto dto);

	Integer saveEmployeeEducationInfo(EducationalDetailListDto dto);
	
	Integer saveAddressInfo(AddressListDto dto);

	Integer saveEmployeeBankInfo(BankDetailsDto dto);

	Integer saveSkillInfo(TechSkillListDto dto);

	Integer saveExperienceInfo(ExperienceListDto dto);

	Integer saveContactInfo(ContactListDto dto);

	EmployeePrimaryInfoDto getEmployeeInfo(String employeeId);
}