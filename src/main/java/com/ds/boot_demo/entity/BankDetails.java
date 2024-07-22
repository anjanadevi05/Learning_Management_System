package com.ds.boot_demo.entity;

import com.ds.boot_demo.dto.EmployeeSecondaryInfoDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Bank_Details")
public class BankDetails {
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "acc_no", unique = true)
	private String accNo;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column(name = "acc_Type")
	private String accType;
	
	@Column(name = "ifsc_code")
	private String ifscCode;
	
	@Column(name = "branch")
	private String branch;
	
	@Column(name = "state")
	private String state;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private EmployeePrimaryDetails primaryinfo;
	

}
