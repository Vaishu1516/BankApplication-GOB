package apiresponse;

import java.time.LocalDateTime;

public class ApiErrorResponse {

	private int status;
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();
    private String path;

    public ApiErrorResponse(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public int getStatus() { return status; }
    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getPath() { return path; }
}
