package com.ds.boot_demo.dto;

import jakarta.persistence.Column;
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
public class AddressDto {
   
	private String addressType;


	private String doorNo;
	
	
	private String Street;
	
	
	private String locality;
	
	
	private String city;
	

	private String landMark;
	
	
	private String state;
	
	
	private Integer pinCode;
	

}
