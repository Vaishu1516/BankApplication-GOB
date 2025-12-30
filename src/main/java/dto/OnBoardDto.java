package dto;
import com.nirmaan.project.AccountType;
import lombok.Data;

@Data
public class OnBoardDto {

	private int onBoard_Id;
	private long accountNumber;
	private String bankName;
	private String branchName;
	private AccountType accountType;
	private String IFSC;
	private long CIF;

}
