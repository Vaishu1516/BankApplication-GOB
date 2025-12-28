package apiresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

	// private LocalDateTime timestamp=LocalDateTime.now(); //for security layer

	private String message;
	private T data;
	private boolean status;

	public static Object builder() {
		return null;
	}
}
