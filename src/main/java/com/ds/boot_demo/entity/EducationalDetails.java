package com.ds.boot_demo.entity;

import java.time.LocalDate;

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
@Table(name="education_detail")
public class EducationalDetails {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	
	@Column(name = "education_type")
	private String educationType;
	
	
	@Column(name = "yop")
	private Integer yop;
	
	@Column(name = "percent")
	private Double percent;
	
	@Column(name = "Uni")
	private String University;
	
	
	@Column(name = "institute")
	private String institute;
	
	
	@Column(name = "specialization")
	private String specialization;
	
	
	@Column(name = "state")
	private String state;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private EmployeePrimaryDetails primaryinfo;

}
