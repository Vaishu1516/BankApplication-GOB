package dto;
 import lombok.Data;

@Data
public class TransactionDto {
	private int transaction_id;
	private long account_Balance;
	private String mini_Statement;

}
