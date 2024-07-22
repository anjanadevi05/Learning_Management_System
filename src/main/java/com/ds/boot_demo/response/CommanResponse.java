package com.ds.boot_demo.response;

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
public class CommanResponse<T> {
	
	private boolean isError;
	private T data;
	private String message;
	

}
