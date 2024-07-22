package com.ds.boot_demo.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="Address")
public class EmployeeAddress {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "address_type")
	private String addressType;
	
	
	@Column(name = "door_no")
	private String doorNo;
	
	@Column(name = "street")
	private String Street;
	
	@Column(name = "locality")
	private String locality;
	
	
	@Column(name = "city")
	private String city;
	
	
	@Column(name = "landmark")
	private String landMark;
	
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pin_code")
	private Integer pinCode;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private EmployeePrimaryDetails primaryinfo;
	

}
