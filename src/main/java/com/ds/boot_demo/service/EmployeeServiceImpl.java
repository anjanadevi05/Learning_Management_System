package com.ds.boot_demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
import com.ds.boot_demo.entity.BankDetails;
import com.ds.boot_demo.entity.ContactDetails;
import com.ds.boot_demo.entity.EducationalDetails;
import com.ds.boot_demo.entity.EmployeeAddress;
import com.ds.boot_demo.entity.EmployeePrimaryDetails;
import com.ds.boot_demo.entity.EmployeeSecondaryDetails;
import com.ds.boot_demo.entity.ExperienceDetails;
import com.ds.boot_demo.entity.TechSkillDetails;
import com.ds.boot_demo.exception.EmployeeException;
import com.ds.boot_demo.repository.PrimaryInfoRepository;
import com.ds.boot_demo.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	/*//instead of defining with @Autowired we use final this is called dependency injection
	private final PrimaryInfoRepository primaryInfoRepository = null;*/
	 @Autowired
	 private PrimaryInfoRepository primaryInfoRepository;

	@Override
	public Integer saveEmployeePrimaryInfo( EmployeePrimaryInfoDto dto) {
		// TODO Auto-generated method stub
		System.err.println("EmployeeServiceImpl :: saveEmployeePrimaryInfo");
		//log.info("EmployeeServiceImpl :: saveEmployeePrimaryInfo");
		//here we use EmployeePrimaryDetails obj because dto obj cant be stored in db
		/*
		EmployeePrimaryDetails employeePrimaryInfo = EmployeePrimaryDetails.builder()
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
				.build();*/
		//the above is being repeated in primary then in secondary so we define it in util package
		EmployeePrimaryDetails employeePrimaryInfo=EmployeeUtil.dtoToEntity(dto);
		
		EmployeePrimaryDetails savedPrimaryInfo=primaryInfoRepository.save(employeePrimaryInfo);
		//primaryInfoRepository.findAll();--many such methods there to delete or delete by specific id
		//return "Employee Primary Info Saved Successfully";
		return savedPrimaryInfo.getId();
	}
	
	@Override
	public Integer saveEmployeeSecondaryInfo( EmployeeSecondaryInfoDto dto) {
		// TODO Auto-generated method stub
		System.err.println("EmployeeServiceImpl :: saveEmployeeSecondaryInfo");
		
		//only after saving the primary data secondary data should be entered-scenario
		//so we check if the exist a primary info for this secondary info
		Optional<EmployeePrimaryDetails> primaryOptional=primaryInfoRepository.findById(dto.getPrimaryInfoId());
		//to check if the primary info is present
		if(primaryOptional.isPresent())
		{
			EmployeePrimaryDetails primaryinfo=primaryOptional.get();
			//passs values got frm dto
			/*EmployeeSecondaryDetails secondaryinfo=EmployeeSecondaryDetails.builder()
					.panNo(dto.getPanNo()).aadharNo(dto.getAadharNo()).fatherName(dto.getFatherName())
					.motherName(dto.getMotherName()).spouseName(dto.getSpouseName())
					.passportNo(dto.getPassportNo()).maritalStatus(dto.getMaritalStatus()).build();*/
			
			EmployeeSecondaryDetails secondaryinfo=EmployeeUtil.dtoToEntity(dto);
			
		primaryinfo.setSecondaryinfo(secondaryinfo);
		secondaryinfo.setPrimaryinfo(primaryinfo);
		
		return primaryInfoRepository.save(primaryinfo).getId();		
		}
		//if not present throw exception
		throw new EmployeeException("Employee Primary Info not Found");
	}
	
	
	@Override
	public Integer saveEmployeeEducationInfo( EducationalDetailListDto dto) {
		// TODO Auto-generated method stub
		System.err.println("EmployeeServiceImpl :: saveEmployeePrimaryInfo");
		Optional<EmployeePrimaryDetails> primaryOptional=primaryInfoRepository.findById(dto.getPrimaryInfoId());
		if(primaryOptional.isPresent())
		{
			EmployeePrimaryDetails primaryinfo=primaryOptional.get();
			
			
			
			/*List<EducationalDetails> educations=dto.getEducationalDetails().stream().map(edu->EducationalDetails.builder()
					.educationType(edu.getEducationType()).yop(edu.getYop())
					.percent(edu.getPercent()).University(edu.getUniversity())
					.institute(edu.getInstitute()).specialization(edu.getSpecialization())
					.state(edu.getState()).build()).collect(Collectors.toList());*/
			
			List<EducationalDetails> educations=EmployeeUtil.dtoToEntities(dto);
			primaryinfo.setEducationalDetails(educations);
			educations.stream().forEach(edu->edu.setPrimaryinfo(primaryinfo));
			
			return primaryInfoRepository.save(primaryinfo).getId();
		}
		throw new EmployeeException("Employee Primary Info not Found");
	}
	
	@Override
	public Integer saveAddressInfo( AddressListDto dto) {
		// TODO Auto-generated method stub
		System.err.println("EmployeeServiceImpl :: saveEmployeeAddressInfo");
		Optional<EmployeePrimaryDetails> primaryOptional=primaryInfoRepository.findById(dto.getEmpId());
		if(primaryOptional.isPresent())
		{
			EmployeePrimaryDetails primaryinfo=primaryOptional.get();
			
			List<EmployeeAddress>addresses=EmployeeUtil.dtoToEntities(dto);
			primaryinfo.setAddresses(addresses);
			addresses.stream().forEach(loc->loc.setPrimaryinfo(primaryinfo));
			
			return primaryInfoRepository.save(primaryinfo).getId();
		}
		throw new EmployeeException("Employee Primary Info not Found");
	}
	
	@Override
	public Integer saveEmployeeBankInfo( BankDetailsDto dto) {
		// TODO Auto-generated method stub
		System.err.println("EmployeeServiceImpl :: saveEmployeeBankInfo");
		
		//only after saving the primary data secondary data should be entered-scenario
		//so we check if the exist a primary info for this secondary info
		Optional<EmployeePrimaryDetails> primaryOptional=primaryInfoRepository.findById(dto.getId());
		//to check if the primary info is present
		if(primaryOptional.isPresent())
		{
			EmployeePrimaryDetails primaryinfo=primaryOptional.get();
			//passs values got frm dto
			/*EmployeeSecondaryDetails secondaryinfo=EmployeeSecondaryDetails.builder()
					.panNo(dto.getPanNo()).aadharNo(dto.getAadharNo()).fatherName(dto.getFatherName())
					.motherName(dto.getMotherName()).spouseName(dto.getSpouseName())
					.passportNo(dto.getPassportNo()).maritalStatus(dto.getMaritalStatus()).build();*/
			
			BankDetails bankacc=EmployeeUtil.dtoToEntity(dto);
			
		primaryinfo.setBankAccinfo(bankacc);
		bankacc.setPrimaryinfo(primaryinfo);
		
		return primaryInfoRepository.save(primaryinfo).getId();		
		}
		//if not present throw exception
		throw new EmployeeException("Employee Primary Info not Found");
	}

	@Override
	public Integer saveSkillInfo(TechSkillListDto dto) {
		// TODO Auto-generated method stub
		System.err.println("EmployeeServiceImpl :: saveEmployeeSkillInfo");
		Optional<EmployeePrimaryDetails> primaryOptional=primaryInfoRepository.findById(dto.getEmpId());
		if(primaryOptional.isPresent())
		{
			EmployeePrimaryDetails primaryinfo=primaryOptional.get();
			
			List<TechSkillDetails>skills=EmployeeUtil.dtoToEntities(dto);
			primaryinfo.setTechSkill(skills);
			skills.stream().forEach(edu->edu.setPrimaryinfo(primaryinfo));
			
			return primaryInfoRepository.save(primaryinfo).getId();
		}
		throw new EmployeeException("Employee Primary Info not Found");
	
	}

	@Override
	public Integer saveExperienceInfo(ExperienceListDto dto) {
		// TODO Auto-generated method stub
		System.err.println("EmployeeServiceImpl :: saveEmployeeExperienceInfo");
		Optional<EmployeePrimaryDetails> primaryOptional=primaryInfoRepository.findById(dto.getEmpId());
		if(primaryOptional.isPresent())
		{
			EmployeePrimaryDetails primaryinfo=primaryOptional.get();
			
			List<ExperienceDetails>experience=EmployeeUtil.dtoToEntities(dto);
			primaryinfo.setExperience(experience);
			experience.stream().forEach(job->job.setPrimaryinfo(primaryinfo));
			
			return primaryInfoRepository.save(primaryinfo).getId();
		}
		throw new EmployeeException("Employee Primary Info not Found");
	}

	@Override
	public Integer saveContactInfo(ContactListDto dto) {
		System.err.println("EmployeeServiceImpl :: saveEmployeeContactInfo");
		Optional<EmployeePrimaryDetails> primaryOptional=primaryInfoRepository.findById(dto.getEmpId());
		if(primaryOptional.isPresent())
		{
			EmployeePrimaryDetails primaryinfo=primaryOptional.get();
			
			List<ContactDetails>contact=EmployeeUtil.dtoToEntities(dto);
			primaryinfo.setContact(contact);
			contact.stream().forEach(ph->ph.setPrimaryinfo(primaryinfo));
			
			return primaryInfoRepository.save(primaryinfo).getId();
		}
		throw new EmployeeException("Employee Primary Info not Found");
		
	}

	@Override
	public EmployeePrimaryInfoDto getEmployeeInfo(String employeeId) {
		// TODO Auto-generated method stub
		Optional<EmployeePrimaryDetails> optionalInfo = primaryInfoRepository.findByemployeeId(employeeId);

		if(optionalInfo != null && optionalInfo.isPresent())
		{
			//convert the entity obj to dto obj
			EmployeePrimaryDetails info=optionalInfo.get();
			
			//will return in one single execution
			return EmployeePrimaryInfoDto.builder().employeeId(info.getEmployeeId())
					.emp_name(info.getEmp_name())
					.dob(info.getDob()) 
					.doj(info.getDoj()) 
					.email(info.getEmail()) 
					.BloodGroup(info.getBloodGroup()) 
					.designation(info.getDesignation()) 
					.gender(info.getGender()) 
					.nationality(info.getNationality()) 
					.employeeStatus(info.getEmployeeStatus())
					
					.secondaryInfo(EmployeeSecondaryInfoDto.builder().panNo(info.getSecondaryinfo().getPanNo())
							.aadharNo(info.getSecondaryinfo().getAadharNo()).fatherName(info.getSecondaryinfo().getFatherName())
							.motherName(info.getSecondaryinfo().getMotherName()).spouseName(info.getSecondaryinfo().getSpouseName())
							.passportNo(info.getSecondaryinfo().getPassportNo()).maritalStatus(info.getSecondaryinfo().getMaritalStatus())
							.build())
					
					.education(info.getEducationalDetails().stream().map(edu->EducationalDetailDto.builder().educationType(edu.getEducationType())
							.yop(edu.getYop()).percent(edu.getPercent()).University(edu.getUniversity())
							.institute(edu.getInstitute()).specialization(edu.getSpecialization())
							.state(edu.getState()).build()).collect(Collectors.toList()))
					
					.addresses(info.getAddresses().stream().map(loc->AddressDto.builder()
							.addressType(loc.getAddressType()).doorNo(loc.getDoorNo())
							.Street(loc.getStreet()).locality(loc.getLocality())
							.city(loc.getCity()).landMark(loc.getLandMark())
							.pinCode(loc.getPinCode()).state(loc.getState())
							.build()).collect(Collectors.toList()))
					
					.bank(BankDetailsDto.builder()
							.accNo(info.getBankAccinfo().getAccNo()).bankName(info.getBankAccinfo().getBankName()).accType(info.getBankAccinfo().getAccType())
							.ifscCode(info.getBankAccinfo().getIfscCode()).branch(info.getBankAccinfo().getBranch())
							.state(info.getBankAccinfo().getState()).build())
					
					.skills(info.getTechSkill().stream().map(skill->TechSkillDto.builder()
							.skillType(skill.getSkillType()).rating(skill.getRating())
							.yoe(skill.getYoe()).build()).collect(Collectors.toList()))
					
					.experience(info.getExperience().stream().map(job->ExperienceDto.builder()
							.companyType(job.getCompanyType()).yearsOfExperience(job.getYearsOfExperience())
							.dateOfJoining(job.getDateOfJoining()).dateOfRelieving(job.getDateOfRelieving())
							.designation(job.getDesignation()).location(job.getLocation())
							.build()).collect(Collectors.toList()))
					
					.contact(info.getContact().stream().map(ph->ContactDto.builder()
							.contactType(ph.getContactType()).contactNumber(ph.getContactNumber())
							.build()).collect(Collectors.toList()))
					.build();
			
		}
		throw new EmployeeException("Employee Primary Info not Found");
		
	}
	   
	}

