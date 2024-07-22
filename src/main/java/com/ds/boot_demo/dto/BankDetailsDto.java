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
public class BankDetailsDto {
    private Integer Id;
	
	private String accNo;
	
	
	private String bankName;
	
	
	private String accType;
	
	
	private String ifscCode;
	
	
	private String branch;
	
	
	private String state;

}
