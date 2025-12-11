package globalexcexception;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import apiresponse.ApiResponse;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(ResourceNotFoundException ex, WebRequest req) {
		return new ResponseEntity<>(
				((Object) ApiResponse.builder())
				.timestamp(LocalDateTime.now())
				.message(ex.getMessage())
				.status(HttpStatus.NOT_FOUND)
				.build(),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<?>>handlerGeneral(Exception ex)
	{
		return ResponseEntity.internalServerError().body(
				ApiResponse.builder()
				.message(ex.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.build()
				);
	}

}
