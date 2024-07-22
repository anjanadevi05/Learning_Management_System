package com.ds.boot_demo.entity;



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
@Table(name="employee_secondary_info")
public class EmployeeSecondaryDetails {

	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "pan_no", unique = true)
	private String panNo;
	
	@Column(name = "aadhar_no", unique = true)
	private String aadharNo;
	
	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "mother_name")
	private String motherName;
	
	@Column(name = "spouse_name")
	private String spouseName;
	
	@Column(name = "passport_no", unique = true)
	private String passportNo;
	
	@Column(name = "marital_status")
	private String maritalStatus;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private EmployeePrimaryDetails primaryinfo;
}
