package com.BankingApp.APIresponce;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public class ApiResponce<T> {
	private LocalDateTime timestamp=LocalDateTime.now();
	
	private String message;
	private T data;
	private HttpStatus status;
	

}
