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
public class EducationalDetailDto {
	//this educational dto class is for only on education...other one is created for multiple edu
   
	private Integer Id;
	
	private String educationType;
	
	private Integer yop;
	
	private Double percent;
	
	private String University;
	
	private String institute;
	
	private String specialization;
	
	private String state;

}
