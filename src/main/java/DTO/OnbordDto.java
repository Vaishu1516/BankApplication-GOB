package dto;

import lombok.Data;

@Data

public class OnbordDto {
	private long Onboarding_id;
	
	private long accountNumber;
	private String branch;
	private String ifsc;
	private String cif;
	private String bankName;
}
