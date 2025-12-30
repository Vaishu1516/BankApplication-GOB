package dto;
import lombok.Data;

@Data
public class PersonalDetailsDto {
	
	private int personal_id;
	private String userName;
	private int mobileNumber;
	private int age;
	private String gender;
}
