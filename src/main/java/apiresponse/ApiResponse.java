package apiresponse;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiResponse<T> {
 
	private LocalDateTime timestamp=LocalDateTime.now(); //for security layer
	
	private String message;
	private T data;
	private HttpStatus status;
	
	public static Object builder() {
		return null;
	}
}
