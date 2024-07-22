package com.ds.boot_demo.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ds.boot_demo.response.CommanResponse;

import com.ds.boot_demo.exception.EmployeeException;

@RestControllerAdvice
public class GenericExceptionHandler {
	
	@ExceptionHandler(value= {EmployeeException.class})
	public ResponseEntity<CommanResponse<Integer>> employeeExceptionHandler(EmployeeException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CommanResponse.<Integer>builder()
				.isError(true).data(null).message(e.getMessage()).build());
		
		/*return ResponseEntity.ok.(CommanResponse.<Integer>builder()
		.isError(true).data(null).message(e.getMessage()).build());
		*/
	}
	
	

}
