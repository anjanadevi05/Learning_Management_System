package com.ds.boot_demo.dto;

import java.util.List;

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
public class AddressListDto {
	
	private Integer empId;//in findby we should use.
	private List<AddressDto> addresses;

}
