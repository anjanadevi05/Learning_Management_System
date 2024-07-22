package com.ds.boot_demo.controller;

import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYEE_PRIMARY_INFO_SAVED_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYEE_PRIMARY_INFO_FETCH_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYEE_CONTACT_INFO_SAVED_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYEE_EDUCATION_INFO_SAVED_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYEE_ADDRESS_INFO_SAVED_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYEE_SECONDARY_INFO_SAVED_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYEE_BANK_INFO_SAVED_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYEE_SKILL_INFO_SAVED_MESSAGE;
import static com.ds.boot_demo.constant.EmployeeConstants.EMPLOYEE_EXPERIENCE_INFO_SAVED_MESSAGE;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.boot_demo.dto.AddressDto;
import com.ds.boot_demo.dto.AddressListDto;
import com.ds.boot_demo.dto.BankDetailsDto;
import com.ds.boot_demo.dto.ContactDto;
import com.ds.boot_demo.dto.ContactListDto;
import com.ds.boot_demo.dto.EducationalDetailDto;
import com.ds.boot_demo.dto.EducationalDetailListDto;
import com.ds.boot_demo.dto.EmployeePrimaryInfoDto;
import com.ds.boot_demo.dto.EmployeeSecondaryInfoDto;
import com.ds.boot_demo.dto.ExperienceDto;
import com.ds.boot_demo.dto.ExperienceListDto;
import com.ds.boot_demo.dto.TechSkillDto;
import com.ds.boot_demo.dto.TechSkillListDto;
import com.ds.boot_demo.entity.EmployeePrimaryDetails;
import com.ds.boot_demo.response.CommanResponse;
import com.ds.boot_demo.service.EmployeeService;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
	
	/*@Autowired
	private EmployeeService employeeservice;*/
	//
	//without setter method we are able to set the values
	
	private final EmployeeService employeeservice;
	
	//here we create a method to fetch the entire info about the particular employee
	//@PathVarable String(employeeId is a string)
	
	
	//we return a response entity obj
	@GetMapping("/primary/{employeeId}")
	public ResponseEntity<CommanResponse<EmployeePrimaryInfoDto>> getEmployeeInfo(@PathVariable String employeeId)
	{
		
		//EmployeePrimaryDetails emp=new EmployeePrimaryDetails();
		//instead of creating obj like the above...we use
		//return EmployeePrimaryInfoDto.builder().emp_name("John").build();
		//return EmployeePrimaryInfoDto.builder().build();--b4 path variable
		//return EmployeePrimaryDetails.builder().dateOfBirth(LocalDate.now()).build();
		//we use the primary info details in such a way that we get all the data back
		log.info("EmployeeServiceImpl :: getEmployeeInfo");
		EmployeePrimaryInfoDto employeeInfo = employeeservice.getEmployeeInfo(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(CommanResponse.<EmployeePrimaryInfoDto>builder().isError(false)
				.data(employeeInfo).message(EMPLOYEE_PRIMARY_INFO_FETCH_MESSAGE).build());
		 
	}

	
	@GetMapping("/secondary")
	public EmployeeSecondaryInfoDto getsecondaryInfo()
	{
		return EmployeeSecondaryInfoDto.builder().build();
	}
	
	@GetMapping("/education")
	public EducationalDetailListDto geteducationInfo()
	{
		
		//EmployeePrimaryDetails emp=new EmployeePrimaryDetails();
		//instead of creating obj like the above...we use
		//return EmployeePrimaryInfoDto.builder().emp_name("John").build();
		//return EmployeeSecondaryInfoDto.builder().build();
		//return EmployeePrimaryDetails.builder().dateOfBirth(LocalDate.now()).build();
		return EducationalDetailListDto.builder().educationalDetails(Arrays.asList(EducationalDetailDto.builder().build())).build();
	}
	
	@GetMapping("/address")
	public AddressListDto getaddressInfo()
	{
		return AddressListDto.builder().addresses(Arrays.asList(AddressDto.builder().build())).build();
	
	}
	
	@GetMapping("/bank")
	public BankDetailsDto getbankInfo()
	{
		return BankDetailsDto.builder().build();
	}
	
	@GetMapping("/skill")
	public TechSkillListDto getskillInfo()
	{
		return TechSkillListDto.builder().techskill(Arrays.asList(TechSkillDto.builder().build())).build();
	
	}
	
	@GetMapping("/experience")
	public ExperienceListDto getexperienceInfo()
	{
		return ExperienceListDto.builder().experience(Arrays.asList(ExperienceDto.builder().build())).build();
	
	}
	
	@GetMapping("/contact")
	public ContactListDto getcontactInfo()
	{
		return ContactListDto.builder().contact(Arrays.asList(ContactDto.builder().build())).build();
	
	}
	/*@PostMapping("/primary")
	public String saveEmployeebasicInfo(@RequestBody EmployeePrimaryInfoDto dto) {
		System.out.println(dto);
		String msg=employeeservice.saveEmployeebasicInfo(dto);
		return msg;
	}*/
	@PostMapping("/primary")
	public ResponseEntity<CommanResponse<Integer>> saveEmployeePrimaryInfo(@RequestBody EmployeePrimaryInfoDto dto) {
		log.info("EmployeeServiceImpl :: saveEmployeePrimaryInfo");
		Integer empid=employeeservice.saveEmployeePrimaryInfo(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommanResponse.<Integer>builder().isError(false).data(empid).message(EMPLOYEE_PRIMARY_INFO_SAVED_MESSAGE).build());
	}
	
	@PutMapping("/secondary")
	public ResponseEntity<CommanResponse<Integer>> saveEmployeeSecondaryInfo(@RequestBody EmployeeSecondaryInfoDto dto) {
		log.info("EmployeeServiceImpl :: saveEmployeeSecondaryInfo");
		Integer primaryid=employeeservice.saveEmployeeSecondaryInfo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommanResponse.<Integer>builder().isError(false).data(primaryid).message(EMPLOYEE_SECONDARY_INFO_SAVED_MESSAGE).build());
	}
	
	@PutMapping("/education")
	public ResponseEntity<CommanResponse<Integer>> saveeducationaldetails(@RequestBody EducationalDetailListDto dto) {
		log.info("EmployeeServiceImpl :: saveEmployeeEducationInfo");
		Integer empid=employeeservice.saveEmployeeEducationInfo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommanResponse.<Integer>builder().isError(false).data(empid).message(EMPLOYEE_EDUCATION_INFO_SAVED_MESSAGE).build());
	}
	
	@PutMapping("/address")
	public ResponseEntity<CommanResponse<Integer>> saveaddressdetails(@RequestBody AddressListDto dto) {
		log.info("EmployeeServiceImpl :: saveEmployeeAddressInfo");
		Integer empid=employeeservice.saveAddressInfo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommanResponse.<Integer>builder().isError(false).data(empid).message(EMPLOYEE_ADDRESS_INFO_SAVED_MESSAGE).build());
	}
	
	@PutMapping("/bank")
	public ResponseEntity<CommanResponse<Integer>> saveEmployeeaccountInfo(@RequestBody BankDetailsDto dto) {
		log.info("EmployeeServiceImpl :: saveEmployeeBankInfo");
		Integer primaryid=employeeservice.saveEmployeeBankInfo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommanResponse.<Integer>builder().isError(false).data(primaryid).message(EMPLOYEE_BANK_INFO_SAVED_MESSAGE).build());
	}
	
	@PutMapping("/skill")
	public ResponseEntity<CommanResponse<Integer>> saveSkillDetails(@RequestBody TechSkillListDto dto) {
		log.info("EmployeeServiceImpl :: saveEmployeeSkillInfo");
		Integer empid=employeeservice.saveSkillInfo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommanResponse.<Integer>builder().isError(false).data(empid).message(EMPLOYEE_SKILL_INFO_SAVED_MESSAGE).build());
	}
	
	@PutMapping("/experience")
	public ResponseEntity<CommanResponse<Integer>> saveExperiencedetails(@RequestBody ExperienceListDto dto) {
		log.info("EmployeeServiceImpl :: saveEmployeeExperienceInfo");
		Integer empid=employeeservice.saveExperienceInfo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommanResponse.<Integer>builder().isError(false).data(empid).message(EMPLOYEE_EXPERIENCE_INFO_SAVED_MESSAGE).build());
	}
	
	@PutMapping("/contact")
	public ResponseEntity<CommanResponse<Integer>> saveContactdetails(@RequestBody ContactListDto dto) {
		log.info("EmployeeServiceImpl :: saveEmployeeContactInfo");
		Integer empid=employeeservice.saveContactInfo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommanResponse.<Integer>builder().isError(false).data(empid).message(EMPLOYEE_CONTACT_INFO_SAVED_MESSAGE).build());
	}

}
