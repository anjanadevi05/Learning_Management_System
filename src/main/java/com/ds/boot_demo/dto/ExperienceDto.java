package com.ds.boot_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExperienceDto {
	
    private String companyType;
	
	
	private String yearsOfExperience;
	
	
	private String dateOfJoining;
	
	
	private String dateOfRelieving;
	
	
	
	private String designation;
	
	
	
	private String location;
	

}
