package com.ds.boot_demo.entity;

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
@Table(name="Tech_skills")
public class TechSkillDetails {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "skill_type")
	private String skillType;
	
	@Column(name = "rating")
	private Integer rating;
	
	@Column(name = "yoe")
	private Double yoe;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private EmployeePrimaryDetails primaryinfo;
	

}
