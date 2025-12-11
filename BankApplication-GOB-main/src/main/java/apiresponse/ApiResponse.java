package apiresponse;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiResponse<T> {
 
	private LocalDateTime timeStap=LocalDateTime.now(); //for security layer
	
	private String message;
	private T data;
	private HttpStatus status;
	
	
	
	
}
